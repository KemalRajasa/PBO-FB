public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKode() {
        return this.kode;
    }

    public String getNama() {
        return this.nama;
    }

    public int getSks() {
        return this.sks;
    }

    // Override method toString() untuk representasi string yang rapi
    @Override
    public String toString() {
        return this.kode + " - " + this.nama + " (" + this.sks + " SKS)";
    }
}
