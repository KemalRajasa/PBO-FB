# Tugas 5 - Pemrograman Berorientasi Objek B

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
  <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/4047e26e-7e44-4010-96fc-baf25eb2cc00" />

- 





