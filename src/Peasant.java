import java.util.ArrayList;

public class Peasant extends BaseHero {
    protected int power;

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.power = 2;
        attack = attack + (power * 3);
        initiative = 0;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {

    }
}
