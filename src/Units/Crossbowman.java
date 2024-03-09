package Units;

import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    protected int arrows, maxArrows;
    protected int rangeAttack;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.maxArrows = 15;
        this.arrows = maxArrows;
        this.rangeAttack = 4;
        attack = 30;
        initiative = 3;
    }

    protected int getArrows() {
        return arrows;
    }


    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return getInfo() + " " + super.toString() + " \u27b6:" + this.arrows;
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
                for (BaseHero ally : allyes) {
                    if (ally instanceof Peasant) {
                        Peasant peasantAlly = (Peasant) ally;
                        if (peasantAlly.getArrows() > 0) {
                            peasantAlly.setArrows(peasantAlly.getArrows() - 1);
                            this.arrows++;
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("I am DIE");
        }
    }
}


