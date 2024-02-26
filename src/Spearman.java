public class Spearman extends BaseHero {
    protected int armor;
    protected int rangeAttack;

    public Spearman(String name, int x, int y) {
        super(name, x, y);
        this.armor = 3;
        this.rangeAttack = 2;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}