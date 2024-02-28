import java.util.ArrayList;

public class Sniper extends BaseHero {
    protected int rangeAtack;

    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.rangeAtack = 4;
        initiative = 3;
    }


    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {

    }
}