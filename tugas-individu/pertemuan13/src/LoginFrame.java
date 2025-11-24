import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private AuthController authController;

    public LoginFrame() {
        authController = new AuthController();

        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);

        txtUser = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        txtPass = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(txtPass, gbc);

        JButton btnLogin = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        add(panel);

        btnLogin.addActionListener(e -> loginProcess());
    }

    private void loginProcess() {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        if (authController.authenticate(user, pass)) {
            JOptionPane.showMessageDialog(this, "Login Berhasil!");

            User loggedUser = new User(user, pass);

            this.dispose();
            new ImageViewerFrame(loggedUser).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Username / Password salah!",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}