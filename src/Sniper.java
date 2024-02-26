public class Sniper extends BaseHero {
    protected int rangeAtack;

    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.rangeAtack = 4;
    }


    @Override
    public String toString() {
        return this.getInfo();
    }
}