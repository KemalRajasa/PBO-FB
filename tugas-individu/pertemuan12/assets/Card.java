
public abstract class Card {
    protected String name;
    protected String effect;

    public Card(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    /**
     * Metode abstract untuk menampilkan detail kartu.
     * Harus di-override oleh setiap subclass.
     */
    public abstract void display();
}
