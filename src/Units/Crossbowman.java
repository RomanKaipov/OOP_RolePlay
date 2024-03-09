package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    protected int arrows;
    protected int rangeAttack;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.arrows = 15;
        this.rangeAttack = 4;
        attack = 300;
        initiative = 3;
    }

    protected int getArrows() {
        return arrows;
    }

    @Override
    public String toString() {
//        return String.format("%s : %d ", getInfo(), this.arrows);
        return super.toString() + " \u27b6:" + this.arrows;
    }

    public String getInfo() {
        return "Арбалетчик";
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (alive()) {
            if (getArrows() > 0) {
                attack(findAliveAllyHero(enemies));
                arrows--;
            } else {
                System.out.println("Out of arrows");
            }

        } else {
            System.out.println("I am DIE");
        }

    }
}
