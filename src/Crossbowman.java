public class Crossbowman extends BaseHero {
    protected int arrows;
    protected int rangeAtack;

    public Crossbowman(String name) {
        super(name);
        this.arrows = 15;
        this.arrows = 2;

    }
    public Crossbowman(){
        super(String.format("Hero_Crossbowman #%d", ++Crossbowman.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}