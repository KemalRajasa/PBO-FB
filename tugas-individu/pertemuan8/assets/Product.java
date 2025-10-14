
public abstract class Product {
    private String kode;
    private String nama;
    private int harga;
    private int stok;

    public Product(String kode, String nama, int harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getters
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }

    // Methods
    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }
}
