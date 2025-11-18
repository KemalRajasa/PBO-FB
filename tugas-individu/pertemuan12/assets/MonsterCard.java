public class MonsterCard extends Card {
    private String attribute;
    private int level;
    private String type;

    public MonsterCard(String name, String attribute, int level, String type, String effect) {
        super(name, effect); // Memanggil constructor dari superclass (Card)
        this.attribute = attribute;
        this.level = level;
        this.type = type;
    }

    @Override
    public void display() {
        System.out.println("Nama    : " + name);
        System.out.println("Atribut : " + attribute);
        System.out.println("Level   : " + level);
        System.out.println("Tipe    : " + type);
        System.out.println("Efek    : " + effect);
        System.out.println("---------------------------------");
    }
}
