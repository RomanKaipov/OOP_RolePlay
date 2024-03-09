package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Sniper extends BaseHero {
    protected int rangeAttack;

    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.rangeAttack = 4;
        initiative = 3;
    }

    public String getInfo() {
        return "Снайпер";
    }

    @Override
    public String toString() {
        return getInfo() + " " + super.toString();
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (alive()){
                attack(findAliveAllyHero(enemies));
        }
        else {
            System.out.println("I am DIE");
        }

    }
}