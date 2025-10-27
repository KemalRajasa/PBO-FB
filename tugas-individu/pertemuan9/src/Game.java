public class Game {
    private Parser parser;
    private Room currentRoom;

    /**
     * Constructor untuk kelas Game.
     * Membuat parser dan semua ruangan di dalam game.
     */
    public Game() {
        parser = new Parser();
        createRooms();
    }

    /**
     * Membuat semua ruangan dan menghubungkan pintu keluarnya (exit).
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("di luar pintu masuk utama universitas");
        theatre = new Room("di dalam gedung teater");
        pub = new Room("di dalam pub kampus");
        lab = new Room("di dalam lab komputer");
        office = new Room("di dalam kantor admin");

        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }
  
    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);   
        }
        System.out.println("Terima kasih telah bermain. Sampai jumpa.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Selamat datang di World of Zuul!");
        System.out.println("World of Zuul adalah game petualangan berbasis teks.");
        System.out.println("Ketik '" + CommandWord.HELP + "' jika Anda butuh bantuan.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Memproses perintah yang diberikan oleh pemain.
     * @param command Perintah yang akan diproses.
     * @return true jika game harus berakhir, false sebaliknya.
     */
    private boolean processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("Saya tidak mengerti apa maksud Anda...");
            return false;
        }

        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                return quit(command);
        }
        return false;
    }

    // --- Implementasi Perintah Pemain ---

    /**
     * Mencetak pesan bantuan.
     */
    private void printHelp() {
        System.out.println("Anda tersesat. Anda sendirian. Anda berkeliling");
        System.out.println("di universitas.");
        System.out.println();
        System.out.println("Perintah Anda adalah:");
        parser.showCommands();
    }

    /**
     * Mencoba pindah ke ruangan lain.
     * @param command Perintah yang berisi arah tujuan.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pergi ke mana?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Tidak ada pintu ke arah sana!");
        } else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * Memberi informasi lokasi pemain saat ini.
     */
    private void printLocationInfo() {
        System.out.println("Anda berada " + currentRoom.getDescription());
        System.out.print(currentRoom.getExitString());
        System.out.println();
    }

    /**
     * Memproses perintah "quit".
     * @param command Perintah yang diberikan.
     * @return true jika pemain ingin keluar.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Keluar dari apa?");
            return false;
        } else {
            return true;
        }
    }
}
