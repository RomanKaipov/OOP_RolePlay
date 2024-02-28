import java.util.ArrayList;

public class Monk extends BaseHero {
    protected int auraAttack;


    public Monk(String name, int x, int y) {
        super(name, x, y);
        this.auraAttack = 10;
        initiative = 1;

    }


    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {

    }
}