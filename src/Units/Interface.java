package Units;

import Units.BaseHero;

import java.util.ArrayList;

public interface Interface {
    void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally);
}
