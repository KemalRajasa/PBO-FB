import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ImageViewerFrame extends JFrame {

    private JLabel imageLabel;
    private User loggedUser;

    public ImageViewerFrame(User user) {

        this.loggedUser = user;

        setTitle("Image Viewer - Welcome " + user.getUsername());
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel topPanel = new JPanel();

        JLabel lblUser = new JLabel("Logged in as: " + loggedUser.getUsername());
        JButton btnOpen = new JButton("Open Image");

        topPanel.add(lblUser);
        topPanel.add(btnOpen);

        add(topPanel, BorderLayout.NORTH);

        imageLabel = new JLabel("No image loaded", SwingConstants.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        btnOpen.addActionListener(e -> openImage());
    }

    private void openImage() {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files (jpg, jpeg, png, gif, bmp)",
                "jpg", "jpeg", "png", "gif", "bmp");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            ImageIcon img = new ImageIcon(file.getAbsolutePath());

            if (img.getIconWidth() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "File bukan gambar!", "Invalid", JOptionPane.ERROR_MESSAGE);
                return;
            }

            imageLabel.setIcon(img);
            imageLabel.setText(null);
        }
    }
}
