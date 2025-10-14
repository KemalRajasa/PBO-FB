import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    // ... (kode hashPassword tidak perlu diubah)
    private static final String ADMIN_PASSWORD_HASH = "f25a2fc72690b780b2a14e140ef6a9e0";

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hashBytes);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritma MD5 tidak ditemukan", e);
        }
    }

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        Chatbot chatbot = new Chatbot();

        while (true) {

            machine.tampilkanProduk();
            System.out.println("\nPilih menu:");
            System.out.println("1. Beli Produk");
            System.out.println("2. Hubungi Bantuan (Chatbot)");
            System.out.println("3. Keluar");
            System.out.println("99. Menu Admin");
            System.out.print("Pilihan Anda: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                System.out.print("\nMasukkan kode produk yang ingin dibeli: ");
                String kode = scanner.nextLine();
                Product produkDipilih = machine.getProductByCode(kode);

                if (produkDipilih == null) {
                    System.out.println("Kode produk tidak valid.");
                } else if (produkDipilih.getStok() == 0) {
                    System.out.println("Maaf, stok " + produkDipilih.getNama() + " telah habis.");
                } else {
                    System.out.println("Anda memilih: " + produkDipilih.getNama() + " dengan harga Rp "
                            + String.format("%,d", produkDipilih.getHarga()));
                    System.out.print("Silakan masukkan uang Anda (nominal bulat): ");
                    try {
                        int uang = Integer.parseInt(scanner.nextLine());
                        machine.prosesPembayaran(produkDipilih, uang);
                    } catch (NumberFormatException e) {
                        System.out.println("Input uang tidak valid. Transaksi dibatalkan.");
                    }
                }
            } else if (pilihan.equals("2")) {
                chatbot.startSession();
            } else if (pilihan.equals("3")) {
                break;
            } else if (pilihan.equals("99")) {
                System.out.print("Masukkan password admin: ");
                String inputPassword = scanner.nextLine().trim();
                String inputHash = hashPassword(inputPassword);

                if (inputHash.equals(ADMIN_PASSWORD_HASH)) {
                    System.out.println("Akses admin diberikan.\n");

                    System.out.println("--- MENU ADMIN ---");
                    System.out.println("1. Lihat Laporan Transaksi");
                    System.out.println("2. Cek Saldo Mesin");
                    System.out.println("3. Tambah Stok Produk");
                    System.out.print("Pilihan Admin: ");
                    String pilihanAdmin = scanner.nextLine();

                    if (pilihanAdmin.equals("1")) {
                        machine.lihatLaporan();
                    } else if (pilihanAdmin.equals("2")) {
                        machine.cekSaldo();
                    } else if (pilihanAdmin.equals("3")) {
                        System.out.print("Masukkan kode produk yang akan ditambah stoknya: ");
                        String kodeProduk = scanner.nextLine().toUpperCase();

                        try {
                            System.out.print("Masukkan jumlah stok yang akan ditambahkan: ");
                            int jumlahTambah = Integer.parseInt(scanner.nextLine());

                            machine.tambahStokProduk(kodeProduk, jumlahTambah);

                        } catch (NumberFormatException e) {
                            System.out.println("Input jumlah tidak valid. Harap masukkan angka.");
                        }
                    } else {
                        System.out.println("Pilihan admin tidak valid.");
                    }

                } else {
                    System.out.println("Password salah. Akses ditolak.");
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }

        System.out.println("Terima kasih telah menggunakan mesin kami.");
        scanner.close();
    }
}
