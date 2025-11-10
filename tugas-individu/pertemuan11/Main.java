import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        // Inisialisasi data diubah, menyertakan nama model
        daftarKendaraan.add(new Mobil("L 1234 AB", "Toyota Avanza", 300000));
        daftarKendaraan.add(new Motor("W 5678 CD", "Honda Vario 125", 100000));
        daftarKendaraan.add(new Mobil("N 9876 RE", "Daihatsu Xenia", 350000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Sistem Rental Kendaraan =====");
            System.out.println("1. Lihat Daftar Kendaraan");
            System.out.println("2. Sewa Kendaraan");
            System.out.println("3. Kembalikan Kendaraan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.println("\n--- Daftar Kendaraan ---");
                    if (daftarKendaraan.isEmpty()) {
                        System.out.println("Belum ada kendaraan terdaftar.");
                    }
                    for (int i = 0; i < daftarKendaraan.size(); i++) {
                        System.out.println("Nomor: " + (i + 1));
                        // Metode printDetails() yang sudah dimodifikasi akan dipanggil
                        daftarKendaraan.get(i).printDetails();
                        System.out.println();
                    }
                    break;

                case "2":
                    System.out.println("\n--- Sewa Kendaraan ---");
                    // Menampilkan namaModel, bukan platNomor
                    for (int i = 0; i < daftarKendaraan.size(); i++) {
                        Kendaraan k = daftarKendaraan.get(i);
                        System.out.println((i + 1) + ". " + k.getNamaModel() +
                                " (" + (k.isDisewa() ? "Disewa" : "Tersedia") + ")");
                    }
                    System.out.print("Masukkan nomor kendaraan yang ingin disewa: ");
                    try {
                        int nomorSewa = Integer.parseInt(scanner.nextLine());
                        int indexSewa = nomorSewa - 1;

                        if (indexSewa >= 0 && indexSewa < daftarKendaraan.size()) {
                            daftarKendaraan.get(indexSewa).sewa();
                        } else {
                            System.out.println("Nomor kendaraan tidak valid.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Harap masukkan angka.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Kembalikan Kendaraan ---");
                    // Menampilkan namaModel, bukan platNomor
                    for (int i = 0; i < daftarKendaraan.size(); i++) {
                        Kendaraan k = daftarKendaraan.get(i);
                        System.out.println((i + 1) + ". " + k.getNamaModel() +
                                " (" + (k.isDisewa() ? "Disewa" : "Tersedia") + ")");
                    }
                    System.out.print("Masukkan nomor kendaraan yang dikembalikan: ");
                    try {
                        int nomorKembali = Integer.parseInt(scanner.nextLine());
                        int indexKembali = nomorKembali - 1;

                        if (indexKembali >= 0 && indexKembali < daftarKendaraan.size()) {
                            Kendaraan k = daftarKendaraan.get(indexKembali);
                            if (k.isDisewa()) {
                                k.kembali();
                                // Pesan konfirmasi menggunakan namaModel
                                System.out.println(k.getNamaModel() + " telah berhasil dikembalikan.");
                            } else {
                                // Pesan eror menggunakan namaModel
                                System.out.println(k.getNamaModel() + " tidak sedang dalam status disewa.");
                            }
                        } else {
                            System.out.println("Nomor kendaraan tidak valid.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Harap masukkan angka.");
                    }
                    break;

                case "4":
                    System.out.println("Terima kasih telah menggunakan sistem kami!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
    }
}