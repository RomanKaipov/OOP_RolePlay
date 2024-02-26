import java.util.Random;
abstract class BaseHero {
    protected static int number;
    protected static Random r;
    protected int maxHp, maxMp, hp, mp, strength, agility, intellect, speed, attack;
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

    }

    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
    }
    public void Attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
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
    public Сoordinates GetСoordinates() {
        return this.coordinates;
    }

    public String GetName() {
        return this.name;
    }

    public float GetDistance(Сoordinates coordinates) {
        return this.coordinates.CalculateDistance(coordinates);
    }



    public String getInfo() {
        return String.format("Name: %s  Type: %s  Hp: %d Attack: %d Сoordinates:%s",
                this.name, this.getClass().getSimpleName(), this.hp, this.attack, this.coordinates);
    }
}
