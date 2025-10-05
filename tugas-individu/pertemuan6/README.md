# Tugas 5 - Pemrograman Berorientasi Objek B

## Task
Membuat sebuah implementasi aplikasi FRS naif sederhana menggunakan bahasa pemrograman java

## Implementasi

### Logika Naif
Sistem akan melakukan output awal berupa `== katalog yugioh ==` dengan beberapa opsi:
  1. opsi pertama : tambahkan kartu ke katalog, yang akan dipecah lagi menjadi 3 	pilihan, 		tambahkan kartu monster, tambahkan kartu trap, tambahkan 	kartu spell:
     
	  - setelahnya, user akan memasukkan detil kartu yang ingin ditambahkan:
    
		  a. jika kartu monster masukkan nama kartu, atribut, level, tipe, effect

		  b. jika kartu trap masukkan nama kartu, tipe, dan effect

		  c. jika kartu spell masukkan nama kartu, tipe, dan effect

  2. opsi kedua : lihat katalog kartu, system akan menanyakan lagi katalog kartu apa yang ingin di lihat, monster, spell atau trap lalu outputkan semua kartu yang telah ditambahkan di group tersebut

  3. opsi ketiga : hapus kartu, hapus kartu dari katalog

  4. opsi keempat : cari kartu, mencari kartu berdasarkan nama kartu

  5. opsi kelima : keluar dari aplikasi
		
### Struktur Class
- [Main.java]([link](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/Main.java)): Merepresentasikan entitas dosen dengan NIDN dan nama.

- [Card.java](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/Card.java): Berfungsi sebagai blueprint untuk sebuah mata kuliah (kode, nama, SKS).

- [CardCatalog.java](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/CardCatalog.java): Merupakan instance dari mata kuliah yang ditawarkan, lengkap dengan dosen pengajar dan manajemen kuota.

- [MonsterCard.java](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/MonsterCard.java): Aktor utama yang memiliki logika untuk mengambil kelas dengan validasi SKS.

- [SpellCard.java](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/SpellCard.java): Class utama yang berisi metode main untuk menjalankan aplikasi

-[TrapCard.java](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan6/assets/TrapCard.java):

### Dokumentasi
- Tampilan relasi antar class di `BlueJ`
  <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/4047e26e-7e44-4010-96fc-baf25eb2cc00" />

- Tampilan aplikasi di terminal
  - Case 1: Menambahkan kartu ke katalog yang di handle dengan `ArrayList` pada kasus ini akan menambahkan ke katalog kartu monster
  <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/25443ead-c42a-4144-af09-e68a6768f678" />

  - Case 2 : Menampilkan kartu yang sudah ditambahkan sebelumnya
  <img width="626" height="638" alt="image" src="https://github.com/user-attachments/assets/317f9931-1b59-4818-8c2d-60f2570916c0" />

  - Case 3 : Menambahkan kartu monster baru bernama Yubel dan menghapus kartu bernama Yubel
  <img width="714" height="682" alt="image" src="https://github.com/user-attachments/assets/ae0373b5-fe1d-46b8-a5fa-3e302aea048d" />
  <img width="608" height="289" alt="image" src="https://github.com/user-attachments/assets/54baf92d-daeb-4ae1-9561-3a90690d8117" />

  - Case 4 : Mencari kartu bernama Dark Magician
  <img width="645" height="551" alt="image" src="https://github.com/user-attachments/assets/60b0cf78-22ad-4a28-b845-b3244384bd85" />







