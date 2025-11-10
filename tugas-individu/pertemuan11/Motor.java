/**
 * Subclass (Kelas Anak) yang mewarisi dari Kendaraan.
 */
public class Motor extends Kendaraan {

    // Constructor diubah untuk menyertakan namaModel
    public Motor(String platNomor, String namaModel, int biayaSewa) {
        super(platNomor, namaModel, biayaSewa);
    }

    /**
     * Implementasi wajib dari metode abstract printDetails()
     */
    @Override
    public void printDetails() {
        System.out.println("--- MOTOR ---");
        System.out.println("Model: " + getNamaModel()); // Menampilkan Nama Model
        System.out.println("Plat Nomor: " + getPlatNomor());
        System.out.println("Biaya Sewa: Rp" + getBiayaSewa() + "/hari");
        System.out.println("Status: " + (isDisewa() ? "Disewa" : "Tersedia"));
    }
}