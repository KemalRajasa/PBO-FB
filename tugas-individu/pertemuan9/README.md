# Tugas 7 - Pemrograman Berorientasi Objek B

## Task

Implementasi terminal text-based game sederhana bernama World of Zuul

## Implementasi

### Logika Naif

Game World of Zuul memiliki alur yang sederhana, di satu ruangan terdapat 1-4 pilihan pintu keluar yang mungkin yaitu `north, east, south, west` dimana player bisa memilih pintu mana untuk keluar dari ruangan itu

### Struktur Class

- [Room](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/Room.java) : Kelas Room merepresentasikan satu lokasi dalam permainan.
- [Game](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/Game.java) : Kelas ini mengatur semua ruangan, mengelola game loop,
- [Main](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/Main.java)
- [Command](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/Command.java) : Kelas Command menyimpan informasi tentang perintah yang diketik pengguna.
- [CommandWord](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/CommandWord.java) : Enum ini mendefinisikan semua kata perintah yang valid dalam permainan.
- [CommandWords](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/CommandWords.java) : Kelas ini menyimpan semua kata perintah (CommandWord) yang valid
- [Parser](https://github.com/KemalRajasa/PBO-FB/blob/main/tugas-individu/pertemuan9/src/Parser.java) : Kelas Parser membaca input dari pengguna dan mengubahnya menjadi objek Command.

### Dokumentasi

- Tampilan aplikasi di terminal
  - <img width="1462" height="412" alt="image" src="https://github.com/user-attachments/assets/e6ff68d9-adc0-4f62-92d7-77e2aa609eea" />










