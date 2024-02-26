import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    protected int arrows;
    protected int rangeAttack;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.arrows = 15;
        this.rangeAttack = 4;
    }

    public String FindEnemy(ArrayList<BaseHero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).GetDistance(GetСoordinates());
        for (int i = 1; i < heroes.size(); i++){
            float tempDistance = heroes.get(i).GetDistance(GetСoordinates());
            if (tempDistance < minDistance){
                minDistance = tempDistance;
                minI = i;
            };
        }
        return String.format("My nearest enemy is %s. Сoordinates:(%d, %d) Distance: %s", heroes.get(minI).GetName(), heroes.get(minI).GetСoordinates().getX(), heroes.get(minI).GetСoordinates().getY(), minDistance);
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}