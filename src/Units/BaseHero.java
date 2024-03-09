package Units;

import java.util.ArrayList;

public abstract class BaseHero implements Interface {

    protected int maxHp, maxMp, hp, mp, strength, agility, intellect, speed, attack, initiative;
    protected String name;
    public Coordinates coordinates;


    public BaseHero(String name, int x, int y) {
        this.name = name;
        this.maxHp = 250;
        this.hp = maxHp;
        this.maxMp = 350;
        this.mp = maxMp;
        this.strength = 13;
        this.agility = 10;
        this.speed = 300;
        this.intellect = 15;
        this.attack = 20;
        this.coordinates = new Coordinates(x, y);
        this.initiative = 0;

    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else {
            this.hp=0;
//            die();
        }
    }

    private void die() {
        System.out.println("DIE");
    }

    public void attack(BaseHero target) {
        int damage = this.attack;
        target.getDamage(damage);
//        System.out.println(this.getClass().getSimpleName() + " " + this.name + " атакует " + target.getClass().getSimpleName() + " " + target.getName() +
//                " урон:" + damage);
    }

    public void Heal(int Hp) {
        if (this.hp < maxHp) {
            this.hp += Hp;
            if (this.hp > maxHp) {
                this.hp = maxHp;
            }
        }
    }

    public void levelUp() {
        this.maxHp += 50;
        this.hp += maxHp;
        this.maxMp += 30;
        this.mp += maxMp;
        this.strength += 2;
        this.agility += 2;
        this.speed += 15;
        this.intellect += 2;
        this.attack += strength + agility + intellect;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public int getInitiative() {
        return initiative;
    }

    public String getName() {
        return this.name;
    }

    public float getDistance(Coordinates coordinates) {
        return this.coordinates.calculateDistance(coordinates);
    }

    public boolean alive() {
        return hp > 0;
    }

    @Override
    public String toString() {
//        return String.format("Name: %s  Type: %s  \u2665: %d",
//                this.name, this.getClass().getSimpleName(), this.hp);
        return  this.name + " \u2665:" + this.hp + " ⚔:" + this.attack;
    }
public String getInfo() {
        return "";
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public BaseHero findAliveAllyHero(ArrayList<BaseHero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).getDistance(getCoordinates());
        for (int i = 1; i < heroes.size(); i++) {
            float tempDistance = heroes.get(i).getDistance(getCoordinates());
            if (heroes.get(i).alive() && (this.name != heroes.get(i).getName()) && (tempDistance < minDistance)) {
                minDistance = tempDistance;
                minI = i;
            }
            ;
        }
        return heroes.get(minI);
    }

    public boolean canMove(ArrayList<BaseHero> ally, Coordinates coordinates) {
        boolean result = true;
        for (BaseHero hero : ally) {
            Coordinates allyCoord = hero.coordinates;
            if ((allyCoord.x == coordinates.x) && (allyCoord.y == coordinates.y) && (hero.alive())) {
                result = false;
            }
        }
        return result;
    }


    public void move(BaseHero target, ArrayList<BaseHero> ally) {
        int dX = coordinates.x - target.coordinates.x;
        int dY = coordinates.y - target.coordinates.y;
        if (Math.abs(dX) > 1 || Math.abs(dY) > 1) {
            if (Math.abs(dX) > Math.abs(dY)) {
                if (dX > 0) {
                    if (canMove(ally, new Coordinates(coordinates.x - 1, coordinates.y))) {
                        coordinates.x-= 1;
//                        System.out.println(getType() + " " + this.name + " go to " + target.getType() + " " + target.getName() + " (X)");
                    } else {
//                        System.out.println(String.format("%s пропускает ход", this.getName()));
                    }
                } else {
                    if (canMove(ally, new Coordinates(coordinates.x + 1, coordinates.y))) {
                        coordinates.x+= 1;
//                        System.out.println(getType() + " " + this.name + " go to " + target.getType() + " " + target.getName() + " (X)");
                    } else {
//                        System.out.println(String.format("%s пропускает ход", this.getName()));
                    }
                }
            } else {
                if (dY > 0) {
                    if (canMove(ally, new Coordinates(coordinates.x, coordinates.y-1))) {
                        coordinates.y-= 1;
//                        System.out.println(getType() + " " + this.name + " go to " + target.getType() + " " + target.getName() + " (Y)");
                    } else {
//                        System.out.println(String.format("%s пропускает ход", this.getName()));
                    }
                } else {
                    if (canMove(ally, new Coordinates(coordinates.x, coordinates.y+1))) {
                        coordinates.y+= 1;
//                        System.out.println(getType() + " " + this.name + " go to " + target.getType() + " " + target.getName() + " (Y)");
                    } else {
//                        System.out.println(String.format("%s пропускает ход", this.getName()));
                    }
                }
            }

        }
    }

    public int getHp() {
        return this.hp;
    }
}
