# Tugas 4 - Pemrograman Berorientasi Objek B

## Task
Membuat sebuah implementasi aplikasi FRS naif sederhana menggunakan bahasa pemrograman java

## Implementasi

### Logika Naif
- Semua batas sks mahasiswa akan di-deklarasikan default 24 sks
- batas sks akan di iterasi berkurang sesuai jumlah kelas sks yang saat ini diambil
- pengambilan kelas akan valid jika kuota kelas belum penuh 40/40 dan jika batas sks mahasiswa tidak kurang dari 0 (sisa sks - sks kelas yang saat ini diambil >= 0)
- kuota kelas di-deklarasikan default 40 peserta
  
### Struktur Class
- Dosen.java: Merepresentasikan entitas dosen dengan NIDN dan nama.

- MataKuliah.java: Berfungsi sebagai blueprint untuk sebuah mata kuliah (kode, nama, SKS).

- Kelas.java: Merupakan instance dari mata kuliah yang ditawarkan, lengkap dengan dosen pengajar dan manajemen kuota.

- Mahasiswa.java: Aktor utama yang memiliki logika untuk mengambil kelas dengan validasi SKS.

- FRS.java: Class utama yang berisi metode main untuk menjalankan aplikasi
  
### Dokumentasi
- Tampilan relasi antar class di `BlueJ`
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/4d5c3011-8c95-4261-9c00-aaac2aa8ae73" />


- Tampilan aplikasi
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d9ec2b44-2ffa-45e2-834e-2f491b249038" />




