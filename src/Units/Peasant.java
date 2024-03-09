package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Peasant extends BaseHero {
    protected int arrows;
    protected boolean flag;
    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.arrows = 10;
        initiative = 0;
        flag = false;
    }


    protected int getArrows() {
        return arrows;
    }


    public void setArrows(int arrows) {
        this.arrows = arrows;
    }
    @Override
    public String toString() {
        return getInfo() + " " + super.toString()+ " \u27b6:" + this.arrows;
    }

    public String getInfo() {
        return "Фермер";
    }
    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        for (BaseHero ally : allyes) {
            if (ally instanceof Crossbowman) {
                Crossbowman crossbowman = (Crossbowman) ally;
                if (this instanceof Peasant && ((Peasant) this).getArrows() > 0 && crossbowman.getArrows() == 0) {
                    crossbowman.setArrows(1);
                    ((Peasant) this).setArrows(((Peasant) this).getArrows() - 1);
                    System.out.println("Peasant " + this.name + " передает стрелу лучнику " + crossbowman.getName());
                }
            }
        }
    }
}
