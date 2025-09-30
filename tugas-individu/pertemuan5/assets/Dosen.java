public class Dosen {
    private String nidn;
    private String nama;

    public Dosen(String nidn, String nama) {
        this.nidn = nidn;
        this.nama = nama;
    }

    // -- Getter Methods --
    public String getNidn() {
        return this.nidn;
    }

    public String getNama() {
        return this.nama;
    }
    
    @Override
    public String toString() {
        return this.nama + " (" + this.nidn + ")";
    }
}
