import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCatalog catalog = new CardCatalog();
        boolean running = true;

        while (running) {
            System.out.println("\n== KATALOG KARTU YU-GI-OH! ==");
            System.out.println("1. Tambahkan Kartu ke Katalog");
            System.out.println("2. Lihat Katalog Kartu");
            System.out.println("3. Hapus Kartu");
            System.out.println("4. Cari Kartu");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCardMenu(scanner, catalog);
                    break;
                case 2:
                    viewCatalogMenu(scanner, catalog);
                    break;
                case 3:
                    deleteCard(scanner, catalog);
                    break;
                case 4:
                    searchCard(scanner, catalog);
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private static void addCardMenu(Scanner scanner, CardCatalog catalog) {
        System.out.println("\n-- Tambah Kartu --");
        System.out.println("1. Tambah Kartu Monster");
        System.out.println("2. Tambah Kartu Spell");
        System.out.println("3. Tambah Kartu Trap");
        System.out.print("Pilih jenis kartu: ");
        int typeChoice = -1;
        try {
            typeChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            scanner.next(); // Membersihkan buffer
            return;
        }
        scanner.nextLine(); 

        switch (typeChoice) {
            case 1:
                System.out.print("Nama Kartu: ");
                String monsterName = scanner.nextLine();
                System.out.print("Atribut (e.g., DARK, LIGHT): ");
                String attribute = scanner.nextLine();
                System.out.print("Level: ");
                int level = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Tipe (e.g., Spellcaster, Dragon): ");
                String monsterType = scanner.nextLine();
                System.out.print("Efek: ");
                String monsterEffect = scanner.nextLine();
                catalog.addMonsterCard(new MonsterCard(monsterName, attribute, level, monsterType, monsterEffect));
                System.out.println("Kartu Monster berhasil ditambahkan!");
                break;
            case 2:
                System.out.print("Nama Kartu: ");
                String spellName = scanner.nextLine();
                System.out.print("Tipe (e.g., Normal, Quick-Play): ");
                String spellType = scanner.nextLine();
                System.out.print("Efek: ");
                String spellEffect = scanner.nextLine();
                catalog.addSpellCard(new SpellCard(spellName, spellType, spellEffect));
                System.out.println("Kartu Spell berhasil ditambahkan!");
                break;
            case 3:
                System.out.print("Nama Kartu: ");
                String trapName = scanner.nextLine();
                System.out.print("Tipe (e.g., Normal, Counter): ");
                String trapType = scanner.nextLine();
                System.out.print("Efek: ");
                String trapEffect = scanner.nextLine();
                catalog.addTrapCard(new TrapCard(trapName, trapType, trapEffect));
                System.out.println("Kartu Trap berhasil ditambahkan!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void viewCatalogMenu(Scanner scanner, CardCatalog catalog) {
        System.out.println("\n-- Lihat Katalog --");
        System.out.println("1. Katalog Monster");
        System.out.println("2. Katalog Spell");
        System.out.println("3. Katalog Trap");
        System.out.print("Pilih katalog yang ingin dilihat: ");
        int viewChoice = -1;
        try {
            viewChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            scanner.next();
            return;
        }
        scanner.nextLine(); 

        switch (viewChoice) {
            case 1:
                catalog.viewMonsterCards();
                break;
            case 2:
                catalog.viewSpellCards();
                break;
            case 3:
                catalog.viewTrapCards();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void deleteCard(Scanner scanner, CardCatalog catalog) {
        System.out.print("\nMasukkan nama kartu yang ingin dihapus: ");
        String cardName = scanner.nextLine();
        if (catalog.deleteCard(cardName)) {
            System.out.println("Kartu '" + cardName + "' berhasil dihapus.");
        } else {
            System.out.println("Kartu '" + cardName + "' tidak ditemukan di katalog manapun.");
        }
    }

    private static void searchCard(Scanner scanner, CardCatalog catalog) {
        System.out.print("\nMasukkan nama kartu yang ingin dicari: ");
        String cardName = scanner.nextLine();
        if (!catalog.searchCard(cardName)) {
            System.out.println("Kartu '" + cardName + "' tidak ditemukan.");
        }
    }
}
