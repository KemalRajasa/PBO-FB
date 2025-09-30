public class FRS {
    public static void main(String[] args) {
        Dosen dosen1 = new Dosen("D001", "Dr. Retno Lestari");
        Dosen dosen2 = new Dosen("D002", "Prof. Iwan Santoso");
        Dosen dosen3 = new Dosen("D003", "Dr. Siti Aminah");


        MataKuliah mk1 = new MataKuliah("IF101", "Dasar Pemrograman", 4);
        MataKuliah mk2 = new MataKuliah("IF102", "Struktur Data", 3);
        MataKuliah mk3 = new MataKuliah("KU201", "Pendidikan Pancasila", 2);
        MataKuliah mk4 = new MataKuliah("MA101", "Kalkulus", 3);

        Kelas kelasDaspro = new Kelas(mk1, dosen1);
        Kelas kelasStrukdat = new Kelas(mk1, dosen1);
        Kelas kelasPancasila = new Kelas(mk3, dosen2);
        Kelas kelasKalkulus = new Kelas(mk4, dosen3);

        Mahasiswa budi = new Mahasiswa("13521001", "Budi Santoso");

        // Mahasiswa mengambil kelas 
        budi.ambilKelas(kelasDaspro);
        budi.ambilKelas(kelasStrukdat);
        budi.ambilKelas(kelasPancasila);
        budi.ambilKelas(kelasKalkulus);

        budi.lihatKrs();

        // 6. Lihat status kelas sekarang
        System.out.println("Status Pendaftaran Kelas Terkini:");
        System.out.println("- " + kelasDaspro.toString());
        System.out.println("- " + kelasStrukdat.toString());
        System.out.println("- " + kelasPancasila.toString());
    }
}
