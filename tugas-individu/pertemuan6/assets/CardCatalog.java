import java.util.ArrayList;
import java.util.Iterator;

/**
 * Kelas ini berfungsi sebagai "grup" atau wadah untuk semua kartu.
 * Mengelola tiga list terpisah untuk setiap jenis kartu.
 */
public class CardCatalog {
    private ArrayList<MonsterCard> monsterCards;
    private ArrayList<SpellCard> spellCards;
    private ArrayList<TrapCard> trapCards;

    public CardCatalog() {
        monsterCards = new ArrayList<>();
        spellCards = new ArrayList<>();
        trapCards = new ArrayList<>();
    }

    // Metode untuk menambah kartu
    public void addMonsterCard(MonsterCard card) {
        monsterCards.add(card);
    }

    public void addSpellCard(SpellCard card) {
        spellCards.add(card);
    }

    public void addTrapCard(TrapCard card) {
        trapCards.add(card);
    }

    // Metode untuk melihat kartu
    public void viewMonsterCards() {
        System.out.println("\n=== KATALOG KARTU MONSTER ===");
        if (monsterCards.isEmpty()) {
            System.out.println("Katalog monster masih kosong.");
        } else {
            for (MonsterCard card : monsterCards) {
                card.display();
            }
        }
    }

    public void viewSpellCards() {
        System.out.println("\n=== KATALOG KARTU SPELL ===");
        if (spellCards.isEmpty()) {
            System.out.println("Katalog spell masih kosong.");
        } else {
            for (SpellCard card : spellCards) {
                card.display();
            }
        }
    }

    public void viewTrapCards() {
        System.out.println("\n=== KATALOG KARTU TRAP ===");
        if (trapCards.isEmpty()) {
            System.out.println("Katalog trap masih kosong.");
        } else {
            for (TrapCard card : trapCards) {
                card.display();
            }
        }
    }

    // Metode untuk menghapus kartu berdasarkan nama
    public boolean deleteCard(String cardName) {
        // Gunakan iterator untuk menghindari ConcurrentModificationException
        Iterator<MonsterCard> monsterIterator = monsterCards.iterator();
        while (monsterIterator.hasNext()) {
            if (monsterIterator.next().getName().equalsIgnoreCase(cardName)) {
                monsterIterator.remove();
                return true;
            }
        }

        Iterator<SpellCard> spellIterator = spellCards.iterator();
        while (spellIterator.hasNext()) {
            if (spellIterator.next().getName().equalsIgnoreCase(cardName)) {
                spellIterator.remove();
                return true;
            }
        }
        
        Iterator<TrapCard> trapIterator = trapCards.iterator();
        while(trapIterator.hasNext()){
            if(trapIterator.next().getName().equalsIgnoreCase(cardName)){
                trapIterator.remove();
                return true;
            }
        }

        return false; // Kartu tidak ditemukan
    }

    // Metode untuk mencari kartu berdasarkan nama
    public boolean searchCard(String cardName) {
        boolean found = false;
        for (MonsterCard card : monsterCards) {
            if (card.getName().equalsIgnoreCase(cardName)) {
                System.out.println("\nKartu ditemukan di Katalog Monster:");
                card.display();
                found = true;
            }
        }
        for (SpellCard card : spellCards) {
            if (card.getName().equalsIgnoreCase(cardName)) {
                System.out.println("\nKartu ditemukan di Katalog Spell:");
                card.display();
                found = true;
            }
        }
        for (TrapCard card : trapCards) {
            if (card.getName().equalsIgnoreCase(cardName)) {
                System.out.println("\nKartu ditemukan di Katalog Trap:");
                card.display();
                found = true;
            }
        }
        return found;
    }
}
