package Units;

import Units.BaseHero;

import java.util.ArrayList;

public class Rogue extends BaseHero {
    protected int stealth;

    public Rogue(String name, int x, int y) {
        super(name, x, y);
        this.stealth = 2;
        attack = attack * stealth;
        initiative = 2;
    }

    public String getInfo() {
        return "Разбойник";
    }

    @Override
    public String toString() {
        return super.toString();
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
