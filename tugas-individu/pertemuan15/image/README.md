# Tugas 14 - Pemrograman Berorientasi Objek B

## Task
Implementasi CRUD sederhana menggunakan JavaFX dan MySQL

## Implementasi


### Logika Naif

Sistem CRUD diilustrasikan dengan sebuah aplikasi library yang dapat menambahkan, menghapus, mengupdate, dan melihat daftar buku yang tersimpan di database MySQL.

        
### Struktur Class
- Book.java (Model)
- BookDAO.java (Data Access Object)
- DatabaseConnection.java (Koneksi Database)
- LibraryApp.java (Aplikasi)

### QUERY Awal Untuk Membuat Tabel Book

```sql
CREATE TABLE books (
    id VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT NOT NULL
);
```

### Dokumentasi
- Tampilan aplikasi
    1. Operasi Create

    ![alt text](image.png)

    2. Operasi Read

    ![alt text](image-1.png)

    3. Operasi Update

    ![alt text](image-2.png)

    4. Operasi Delete

    ![alt text](image-3.png)

- Tampilan database tabel book

![alt text](image-4.png)