package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Spearman extends BaseHero {
    protected int armor;
    protected int rangeAttack;

    public Spearman(String name, int x, int y) {
        super(name, x, y);
        this.armor = 3;
        this.rangeAttack = 2;
        initiative = 2;
    }

    @Override
    public String toString() {
        return getInfo() + " " + super.toString();
    }


    public String getInfo() {
        return "Копейщик";
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (alive()) {
            BaseHero enemy = findAliveAllyHero(enemies);
            BaseHero ally = findAliveAllyHero(allyes);
            Coordinates enemyCoord = enemy.coordinates;
            if (Math.abs(coordinates.x - enemyCoord.x) <= 1 && Math.abs(coordinates.y - enemyCoord.y) <= 1) {
                attack(enemy);
            } else {
                move(enemy, allyes);
            }
        }
    }
}