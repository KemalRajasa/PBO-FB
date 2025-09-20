import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Kelas Clock menampilkan jam digital real-time berbasis GUI.
 * Jam ini mengambil waktu langsung dari sistem komputer
 *
 */
public class Clock extends JFrame {

    private JLabel labelWaktu;
    private JLabel labelZonaWaktu;

    public Clock() {
        // GUI
        setTitle("Jam Digital Real-Time");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

        //label untuk menampilkan waktu
        labelWaktu = new JLabel();
        labelWaktu.setFont(new Font("Arial", Font.BOLD, 72));
        labelWaktu.setHorizontalAlignment(SwingConstants.CENTER);
        labelWaktu.setForeground(Color.DARK_GRAY);
        panel.add(labelWaktu, BorderLayout.CENTER);

        //label untuk menampilkan zona waktu
        labelZonaWaktu = new JLabel();
        labelZonaWaktu.setFont(new Font("Arial", Font.PLAIN, 16));
        labelZonaWaktu.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelZonaWaktu, BorderLayout.SOUTH);

        startClock();
    }

    private void startClock() {
        // gunakan waktu lokal device
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZoneId zonaWaktuDefault = ZoneId.systemDefault();
        labelZonaWaktu.setText("Zona Waktu: " + zonaWaktuDefault.getId());

        Timer timer = new Timer(1000, e -> {
            LocalTime waktuSekarang = LocalTime.now(zonaWaktuDefault);
            String waktuTerformat = waktuSekarang.format(formatter);
            labelWaktu.setText(waktuTerformat);
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Clock jam = new Clock(); 
            jam.setVisible(true);
        });
    }
}
