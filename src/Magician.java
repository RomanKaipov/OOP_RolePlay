public class Magician extends BaseHero {
    protected int attackFire;

    public Magician(String name, int x, int y) {
        super(name, x, y);
        this.attackFire = 15;
        attack = attack + attackFire;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}