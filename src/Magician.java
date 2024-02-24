public class Magician extends BaseHero {
    protected int attackFire;

    public Magician(String name) {
        super(name);
        this.attackFire = Magician.r.nextInt(10, 20);
        attack = attack + attackFire;
    }
    public Magician(){
        super(String.format("Hero_Magician #%d", ++Magician.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}