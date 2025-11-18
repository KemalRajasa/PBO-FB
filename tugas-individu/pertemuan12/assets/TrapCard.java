public class TrapCard extends Card {
    private String type;

    public TrapCard(String name, String type, String effect) {
        super(name, effect);
        this.type = type;
    }

    @Override
    public void display() {
        System.out.println("Nama    : " + name);
        System.out.println("Tipe    : " + type + " Trap");
        System.out.println("Efek    : " + effect);
        System.out.println("---------------------------------");
    }
}
