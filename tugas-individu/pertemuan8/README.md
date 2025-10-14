# EVALUASI TENGAH SEMESTER - PBO B

## TABLE OF CONTENT

[Ketentuan](#ketentuan)

[Implementasi Sistem Vending Machine](#implementasi)

[Struktur Class beserta Source Code](#struktur-class)

[Dokumentasi](#dokumentasi)

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

### 3. Fitur tambahan

Sedikit tambahan fitur selain fitur baselina aplikasi vending machine:

- Agar pembeli tidak bisa menggunakan hak akses admin, maka digunakan password untuk memakai fitur khusus admin dan password disimpan dalam bentuk hash MD5 (tidak direkomendasikan menggunakan MD5 di dunia nyata karena sudah terlalu umum dan high-risk untuk collision)
- Admin bisa melakukan refill atau menambah stok, jika stok mencapai suatu produk mencapai 0, aplikasi akan mengirim email bahwa produk tsb kosong
- Customer support (Chatbot)

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

Relasi class di BlueJ

<img width="1505" height="741" alt="image" src="https://github.com/user-attachments/assets/a54dcbf5-8df2-42a8-b630-23097d38b566" />


Output aplikasi ketika pengguna sedang membeli 

- Case 1 : Pembelian produk, `STOK : ADA`, `UANG : PAS`

  <img width="501" height="480" alt="image" src="https://github.com/user-attachments/assets/b2c3ec7e-c388-4de8-8e6a-c8dd4f9dab7a" />

- Case 2 : Pembelian produk, `STOK : ADA`, `UANG : TIDAK CUKUP`

  <img width="496" height="426" alt="image" src="https://github.com/user-attachments/assets/6483dfbe-830c-49f6-8fa7-f483ad8b6ddb" />

- Case 3 : Pembelian produk, `STOK : ADA`, `UANG : LEBIH`

  <img width="500" height="449" alt="image" src="https://github.com/user-attachments/assets/f38a339a-daa4-4f66-9f0d-57b2bc08c9f4" />

- Case 4 : Pembelian produk, `STOK : Tidak Ada`

  <img width="431" height="338" alt="image" src="https://github.com/user-attachments/assets/3125421b-2fe4-41da-9127-bf1565d81736" />

Output aplikasi untuk fitur admin

- Case 1 : Tampilkan log pembelian (pembelian invalid tidak masuk ke log transaksi)
  
  <img width="658" height="463" alt="image" src="https://github.com/user-attachments/assets/c041c5bb-2f5b-41bb-addf-6c5dd3d72dd5" />

- Case 2 : Tampilkan saldo yang ada di dalam vending machine

  <img width="461" height="406" alt="image" src="https://github.com/user-attachments/assets/05f36d22-7d6c-4abe-b2bd-36adcbb359dc" />

Output fitur tambahan security :

- Case 1 : password benar

  <img width="450" height="433" alt="image" src="https://github.com/user-attachments/assets/e5d15be9-3ee2-4cb4-a7a8-093791b3df3c" />

- Case 2 : password salah

  <img width="443" height="360" alt="image" src="https://github.com/user-attachments/assets/05aba31c-d2b3-41b9-aa77-12babce0bd5b" />












