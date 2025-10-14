import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaksi {
    private Product produk;
    private int jumlahBayar;
    private int kembalian;
    private LocalDateTime waktuTransaksi;

    public Transaksi(Product produk, int jumlahBayar, int kembalian) {
        this.produk = produk;
        this.jumlahBayar = jumlahBayar;
        this.kembalian = kembalian;
        this.waktuTransaksi = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Waktu: %s, Produk: %s, Bayar: %d, Kembalian: %d",
                waktuTransaksi.format(formatter), produk.getNama(), jumlahBayar, kembalian);
    }
}
