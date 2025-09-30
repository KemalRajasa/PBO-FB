
import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String nama;
    private int batasSks;
    private int sisaSks;
    private ArrayList<Kelas> listKelas;

    // constructor
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.batasSks = 24;
        this.sisaSks = 24;
        this.listKelas = new ArrayList<>();
    }

    public void ambilKelas(Kelas kelas) {
        System.out.println("--- " + this.nama + " mencoba mengambil " + kelas.getMataKuliah().getNama() + " ---");
        
        if (this.sisaSks < kelas.getMataKuliah().getSks()) {
            System.out.println("🔴 GAGAL: Sisa SKS tidak cukup. (Sisa: " + this.sisaSks + ", Butuh: " + kelas.getMataKuliah().getSks() + ")");
            return;
        }

        if (kelas.isPenuh()) {
            System.out.println("🔴 GAGAL: Kuota kelas " + kelas.getMataKuliah().getNama() + " sudah penuh.");
            return;
        }

        kelas.tambahMahasiswa(this);
        this.listKelas.add(kelas);
        this.sisaSks -= kelas.getMataKuliah().getSks();
        
        System.out.println("✅ BERHASIL: " + this.nama + " terdaftar di kelas " + kelas.getMataKuliah().getNama() + ".");
        System.out.println("   Sisa SKS sekarang: " + this.sisaSks + "\n");
    }

    public void lihatKrs() {
        System.out.println("=========================================");
        System.out.println("KARTU RENCANA STUDI - " + this.nama + " (" + this.nim + ")");
        System.out.println("=========================================");
        if (this.listKelas.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            int totalSksDiambil = 0;
            System.out.printf("%-30s | %s\n", "Mata Kuliah (SKS)", "Dosen Pengajar");
            System.out.println("----------------------------------------------------");
            
            for (Kelas kls : this.listKelas) {
                String mataKuliahInfo = String.format("%s (%d SKS)", 
                                        kls.getMataKuliah().getNama(), 
                                        kls.getMataKuliah().getSks());
                // Tampilkan info matkul dan nama dosennya
                System.out.printf("%-30s | %s\n", mataKuliahInfo, kls.getDosen().getNama());
                totalSksDiambil += kls.getMataKuliah().getSks();
            }
            
            System.out.println("----------------------------------------------------");
            System.out.println("Total SKS diambil : " + totalSksDiambil);
            System.out.println("Sisa SKS          : " + this.sisaSks);
        }
        System.out.println("=========================================\n");
    }
}
