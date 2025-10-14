import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<String, Product> products;
    private List<Transaksi> laporanTransaksi;
    private int saldoMesin;

    public VendingMachine() {
        this.products = new LinkedHashMap<>();
        this.laporanTransaksi = new ArrayList<>();
        this.saldoMesin = 0;
        isiMesin();
    }

    private void isiMesin() {
        products.put("A1", new Snack("A1", "Chitato", 8000, 10));
        products.put("A2", new Snack("A2", "Taro", 5000, 15));
        products.put("B1", new Drink("B1", "Coca-Cola", 6000, 12));
        products.put("B2", new Drink("B2", "Teh Pucuk", 4000, 0));
    }

    public void tampilkanProduk() {
        System.out.println("=====================================================");
        System.out.println("      SELAMAT DATANG DI VENDING SNACK MACHINE");
        System.out.println("=====================================================");
        System.out.println("| Kode | Nama Produk         | Harga      | Stok |");
        System.out.println("-----------------------------------------------------");
        for (Product p : products.values()) {
            System.out.printf("| %-4s | %-19s | Rp %-7s | %-4d |\n",
                    p.getKode(), p.getNama(), String.format("%,d", p.getHarga()), p.getStok());
        }
        System.out.println("-----------------------------------------------------");
    }

    public Product getProductByCode(String kode) {
        return products.get(kode.toUpperCase());
    }

    public boolean prosesPembayaran(Product produk, int jumlahUang) {
        if (jumlahUang >= produk.getHarga()) {
            int kembalian = jumlahUang - produk.getHarga();
            saldoMesin += produk.getHarga();
            produk.kurangiStok();

            laporanTransaksi.add(new Transaksi(produk, jumlahUang, kembalian));

            System.out.println("\nPembayaran diterima.");
            System.out.println("Produk " + produk.getNama() + " telah dikeluarkan.");
            if (kembalian > 0) {
                System.out.println("Kembalian Anda: Rp " + String.format("%,d", kembalian));
            }
            System.out.println("Terima kasih!");
            return true;
        } else {
            System.out.println("Maaf, uang Anda tidak cukup. Transaksi dibatalkan.");
            return false;
        }
    }

    public void lihatLaporan() {
        System.out.println("\n--- LAPORAN TRANSAKSI ---");
        if (laporanTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (int i = 0; i < laporanTransaksi.size(); i++) {
                System.out.println((i + 1) + ". " + laporanTransaksi.get(i));
            }
        }
        System.out.println("-------------------------");
    }

    public void cekSaldo() {
        System.out.printf("Total saldo di dalam mesin: Rp %,d\n", saldoMesin);
    }

    public void tambahStokProduk(String kode, int jumlah) {
        Product produk = getProductByCode(kode);

        if (produk != null) {
            produk.tambahStok(jumlah);
            System.out.println(
                    "Stok untuk produk '" + produk.getNama() + "' berhasil ditambahkan sebanyak " + jumlah + ".");
            System.out.println("Stok sekarang: " + produk.getStok());
        } else {
            System.out.println("Produk dengan kode '" + kode + "' tidak ditemukan.");
        }
    }
}
