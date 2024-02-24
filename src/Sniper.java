public class Sniper extends BaseHero {
    protected int rangeAtack;

    public Sniper(String name) {
        super(name);
        this.rangeAtack = Sniper.r.nextInt(2, 4);
    }
    public Sniper(){
        super(String.format("Hero_Sniper #%d", ++Sniper.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}