import java.util.Random;
abstract class BaseHero implements Interface{
    protected static int number;
    protected static Random r;
    protected int maxHp, maxMp, hp, mp, strength, agility, intellect, speed, attack, initiative;
    protected String name, team;
    protected Сoordinates coordinates;
    protected static float distance;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

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
        this.coordinates = new Сoordinates(x,y);
        this.initiative = 0;

    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else {
            die();
        }
    }

    private void die() {
        System.out.println("DIE");
    }

    public void attack(BaseHero target) {
        int damage = 10;
        target.getDamage(damage);
        System.out.println(this.getClass().getSimpleName() + " " + this.name + " атакует " + target.getClass().getSimpleName() + " " + target.getName() +
                " урон:" + damage);
    }

    public void Heal(int Hp) {
        if (this.hp < maxHp) {
            this.hp += Hp;
            if (this.hp >maxHp){
                this.hp=maxHp;
            }
        }
    }
    public void levelUp() {
        this.maxHp += BaseHero.r.nextInt(50, 100);
        this.hp += maxHp;
        this.maxMp += BaseHero.r.nextInt(25, 50);
        this.mp += maxMp;
        this.strength += BaseHero.r.nextInt(1, 5);
        this.agility += BaseHero.r.nextInt(1, 5);
        this.speed += BaseHero.r.nextInt(10, 20);
        this.intellect += BaseHero.r.nextInt(1, 5);
        this.attack += strength+agility+intellect;
    }
    public Сoordinates getСoordinates() {
        return this.coordinates;
    }

    public int getInitiative() {
        return initiative;
    }

    public String getName() {
        return this.name;
    }

    public float getDistance(Сoordinates coordinates) {
        return this.coordinates.calculateDistance(coordinates);
    }

    public boolean alive(){
        return hp>0;
    }

    public String getInfo() {
        return String.format("Name: %s  Type: %s  Hp: %d",
                this.name, this.getClass().getSimpleName(), this.hp);
    }

}
