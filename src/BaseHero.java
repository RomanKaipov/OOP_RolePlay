import java.util.Random;
abstract class BaseHero {
    protected static int number;
    protected static Random r;
    protected int maxHp, maxMp, hp, mp, strength, agility, intellect, speed, attack;
    protected String name;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(String name) {
        this.name = name;
        this.maxHp = BaseHero.r.nextInt(200, 400);
        this.hp = maxHp;
        this.maxMp = BaseHero.r.nextInt(150, 270);
        this.mp = maxMp;
        this.strength = BaseHero.r.nextInt(10, 25);
        this.agility = BaseHero.r.nextInt(15, 45);
        this.speed = 300;
        this.intellect = BaseHero.r.nextInt(5, 35);
        this.attack = BaseHero.r.nextInt(10, 30);
    }

    public BaseHero(){
        this(String.format("Hero_#%d", ++BaseHero.number));
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

    public String getInfo() {
        return String.format("Name: %s  Type: %s  Hp: %d Attack: %d",
                this.name, this.getClass().getSimpleName(), this.hp, this.attack);
    }
}
