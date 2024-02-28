import java.util.ArrayList;
import java.util.Optional;

public class Crossbowman extends BaseHero {
    protected int arrows;
    protected int rangeAttack;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.arrows = 15;
        this.rangeAttack = 4;
        initiative = 3;
    }

    public BaseHero findEnemy(ArrayList<BaseHero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).getDistance(getСoordinates());
        for (int i = 1; i < heroes.size(); i++){
            float tempDistance = heroes.get(i).getDistance(getСoordinates());
            if (tempDistance < minDistance){
                minDistance = tempDistance;
                minI = i;
            };
        }
        return heroes.get(minI);
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
    public void step(ArrayList<BaseHero> heroes) {
        if (alive()){
            if (getArrows()>0) {
                attack(findEnemy(heroes));
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
