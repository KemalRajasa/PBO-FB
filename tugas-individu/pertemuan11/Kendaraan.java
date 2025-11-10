/**
 * Superclass (Kelas Induk) abstrak untuk semua kendaraan.
 * Berisi semua atribut dan metode yang umum.
 */
public abstract class Kendaraan {
    private String platNomor;
    private String namaModel; // ATRIBUT BARU
    private int biayaSewa;
    private boolean disewa;

    // Constructor diubah untuk menerima namaModel
    public Kendaraan(String platNomor, String namaModel, int biayaSewa) {
        this.platNomor = platNomor;
        this.namaModel = namaModel;
        this.biayaSewa = biayaSewa;
        this.disewa = false;
    }

    // Getter untuk atribut baru
    public String getNamaModel() {
        return namaModel;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public int getBiayaSewa() {
        return biayaSewa;
    }

    public boolean isDisewa() {
        return disewa;
    }

    public void sewa() {
        if (!disewa) {
            this.disewa = true;
            // Menggunakan namaModel untuk pesan yang lebih ramah
            System.out.println(namaModel + " berhasil disewa.");
        } else {
            System.out.println("Maaf, " + namaModel + " sudah disewa.");
        }
    }

    public void kembali() {
        if (disewa) {
            this.disewa = false;
        }
    }

    // Memaksa setiap kelas anak untuk memiliki metode ini
    public abstract void printDetails();
}