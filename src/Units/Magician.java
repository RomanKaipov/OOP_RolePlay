package Units;

import Units.BaseHero;

import java.util.ArrayList;
import java.util.Comparator;

public class Magician extends BaseHero {
    private boolean flag;

    public Magician(String name, int x, int y) {
        super(name, x, y);
        initiative = 1;
        flag = false;
    }

    public String getInfo() {
        return "Ведьмак";
    }
    @Override
    public String toString() {
        return getInfo() + " " + super.toString();
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allyes) {
        if (!alive()) return;
        ArrayList<BaseHero> sortlist = new ArrayList<>(allyes);
        ArrayList<BaseHero> deadlist = new ArrayList<>();
        sortlist.sort(Comparator.comparingInt(BaseHero::getHp));
        for (BaseHero hero : sortlist) {
            if (hero.getHp() == 0) {
                deadlist.add(hero);
            }
        }
        if (deadlist.size() > 3) {
            flag = true;
            System.out.println("Флаг установлен");
        }

        if (flag && mp >= 10) {
            deadlist.sort((o1, o2) -> o2.speed - o1.speed);
            deadlist.getFirst().hp = maxHp;
            mp -= 10;
            System.out.println(this.name +" Воскресил: " + deadlist.getFirst().name);
            flag = false;
            return;
        }
        if (flag) {
            mp++;
            return;
        }
        if (mp < 2) {
            mp++;
            return;
        }
        Heal(sortlist.getFirst(),2);
        mp -= 2;
    }
}