public class Peasant extends BaseHero {
    protected int power;

    public Peasant(String name) {
        super(name);
        this.power = Peasant.r.nextInt(1, 5);
        attack = attack + (power * 3);
    }
    public Peasant(){
        super(String.format("Hero_Peasant #%d", ++Peasant.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}
