import java.util.ArrayList;

public class Sniper extends BaseHero {
    protected int rangeAttack;

    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.rangeAttack = 4;
        initiative = 3;
    }


    @Override
    public String toString() {
        return this.getInfo();
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