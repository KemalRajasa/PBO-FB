# EVALUASI TENGAH SEMESTER - PBO B

## TABLE OF CONTENT
[1. Ketentuan](#ketentuan)
  [1a. Fitur](#tentukan-fitur-yang-ada-pada-mesin)
  [1b. Rancangan Kelas](#gambarkan-rancangan-kelas-dan-rancangan-obyek-vending-snack-machine)

[2. Implementasi Sistem Vending Machine](#implementasi)

[3. Struktur Class beserta Source Code](#struktur-class)

[4. Dokumentasi](#dokumentasi)

## Task
Membuat sebuah implementasi vending machine naif

## Ketentuan

### 1. Tentukan fitur yang ada pada mesin
   
    Fitur vending machine akan dibagi sesuai role, tiap `role` memiliki hak akses berbeda
  
       - Fitur Role Admin:
         - Mengecek Stok: Melihat sisa stok untuk semua produk.
         - Menambah Stok (Refill): Menambahkan jumlah stok untuk produk tertentu.
         - Melihat Laporan Transaksi: Melihat riwayat semua transaksi yang telah terjadi.
         - Mengecek Saldo Mesin: Melihat total uang yang terkumpul di dalam mesin.
   
       - Fitur Role Pengguna:
         -  Melihat daftar produk: menampilkan snack yang dijual di vending machine beserta atribut nya
         -  Memilih produk
         -  Melakukan pembayaran
         -  Menerima produk dan kembalian
         -  Membatalkan transaksi
         
### 2. Gambarkan rancangan kelas dan rancangan obyek vending  Snack Machine

    Kelas utama yang digunakan adalah sebagai berikut:

        1. Product (Abstract Class): Kelas dasar untuk semua produk
           - Atribut: kode (String), nama (String), harga (int), stok (int)
           - Method: getKode(), getNama(), getHarga(), getStok(), kurangiStok(), tambahStok()
   
        2. Snack : Turunan dari Product untuk item jenis makanan ringan
   
        3. Minuman : Turunan dari Product untuk item minuman
   
        4. Transaksi : Objek untuk menyimpan data setiap transaksi.
           - Atribut: produk (Product), jumlahBayar (int), kembalian (int), waktuTransaksi (LocalDateTime).
   
        5. VendingMachine (Main Class): Kelas utama yang mengelola semua logika
           - Atribut: products (Map<String, Product>), laporanTransaksi (List<Transaksi>), saldoMesin (int).
           - Method: tampilkanProduk(), pilihProduk(kode), prosesPembayaran(produk, jumlahUang),
                     tambahStokProduk(kode, jumlah), lihatLaporan(), cekSaldo().
    
   
3. Buatkan output simulasi vending snack machine
4. Implementasikan dalam bentuk aplikasi simulasi vending snack machine 
5. Buatlah Video Presentasi yang menjelaskan pekerjaanmu kemudian upload di Youtube

## Implementasi

### Alur Sistem (Flow)
  
Alur kerja Vending Coffee Machine
 - Mesin aktif → menampilkan menu pilihan produk.
 - Pengguna memilih jenis produk
 - Mesin menampilkan total harga.
 - Pengguna melakukan pembayaran.
 - Mesin memverifikasi pembayaran → jika cukup → mengeluarkan produk
 - Transaksi disimpan ke log.
 - Jika stok habis → admin diingatkan untuk refill.


### Struktur Class

- [SupportFRS](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan7/assets/SupportFRS.java)

### Dokumentasi

- Tampilan aplikasi di terminal
  - <img width="1462" height="412" alt="image" src="https://github.com/user-attachments/assets/e6ff68d9-adc0-4f62-92d7-77e2aa609eea" />










