package Units;

import Units.BaseHero;

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
        return super.toString();
    }

    public String getInfo() {
        return "Монах";
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (alive()) {
            BaseHero enemy = findAliveAllyHero(enemies);
            BaseHero ally = findAliveAllyHero(allyes);
            Coordinates enemyCoord = enemy.coordinates;
            if (Math.abs(coordinates.x - enemyCoord.x) <= 1 && Math.abs(coordinates.y - enemyCoord.y) <= 1) {
                attack(enemy);
            }
            else {
                move(enemy,allyes);
            }
        }
    }
}