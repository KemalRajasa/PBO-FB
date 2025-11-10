/**
 * Subclass (Kelas Anak) yang mewarisi dari Kendaraan.
 */
public class Mobil extends Kendaraan {

    // Constructor diubah untuk menyertakan namaModel
    public Mobil(String platNomor, String namaModel, int biayaSewa) {
        // 'super()' memanggil constructor baru dari Kendaraan
        super(platNomor, namaModel, biayaSewa);
    }

    /**
     * Implementasi wajib dari metode abstract printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("--- MOBIL ---");
        System.out.println("Model: " + getNamaModel()); // Menampilkan Nama Model
        System.out.println("Plat Nomor: " + getPlatNomor());
        System.out.println("Biaya Sewa: Rp" + getBiayaSewa() + "/hari");
        System.out.println("Status: " + (isDisewa() ? "Disewa" : "Tersedia"));
    }
}