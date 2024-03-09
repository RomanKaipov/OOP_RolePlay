package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Magician extends BaseHero {
    protected int attackFire;

    public Magician(String name, int x, int y) {
        super(name, x, y);
        this.attackFire = 15;
        attack = attack + attackFire;
        initiative = 1;
    }

    public String getInfo() {
        return "Ведьмак";
    }
    @Override
    public String toString() {
        return getInfo() + " " + super.toString();
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {

    }
}