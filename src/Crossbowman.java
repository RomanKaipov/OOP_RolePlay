import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    protected int arrows;
    protected int rangeAttack;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.arrows = 15;
        this.rangeAttack = 4;
        initiative = 3;
    }

    protected int getArrows(){
        return arrows;
    }
    @Override
    public String toString() {
//        return this.getInfo();
        return String.format("%s Arrows: %d", getInfo(), this.arrows);
    }



    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (alive()){
            if (getArrows()>0) {
                attack(findAliveAllyHero(enemies));
                arrows --;
            }
            else {
                System.out.println("Out of arrows");
            }

        }
        else {
            System.out.println("I am DIE");
        }

    }
}
