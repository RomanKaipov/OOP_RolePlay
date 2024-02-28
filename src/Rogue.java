import java.util.ArrayList;

public class Rogue extends BaseHero {
    protected int stealth;

    public Rogue(String name, int x, int y) {
        super(name, x, y);
        this.stealth = 2;
        attack = attack * stealth;
        initiative = 2;
    }


    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {

    }
}