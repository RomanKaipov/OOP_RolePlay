public class Rogue extends BaseHero {
    protected int stealth;

    public Rogue(String name, int x, int y) {
        super(name, x, y);
        this.stealth = 2;
        attack = attack * stealth;
    }


    @Override
    public String toString() {
        return this.getInfo();
    }
}