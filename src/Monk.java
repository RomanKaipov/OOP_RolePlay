public class Monk extends BaseHero {
    protected int auraAttack;


    public Monk(String name) {
        super(name);
        this.auraAttack = Monk.r.nextInt(15, 25);

    }
    public Monk(){
        super(String.format("Hero_Monk #%d", ++Crossbowman.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}