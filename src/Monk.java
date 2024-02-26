public class Monk extends BaseHero {
    protected int auraAttack;


    public Monk(String name, int x, int y) {
        super(name, x, y);
        this.auraAttack = 10;

    }


    @Override
    public String toString() {
        return this.getInfo();
    }
}