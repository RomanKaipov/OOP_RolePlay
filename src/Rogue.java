public class Rogue extends BaseHero {
    protected int stealth;

    public Rogue(String name) {
        super(name);
        this.stealth = Rogue.r.nextInt(1, 3);
        attack = attack * stealth;
    }
    public Rogue(){
        super(String.format("Hero_Rogue #%d", ++Rogue.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}