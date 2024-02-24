public class Spearman extends BaseHero {
    protected int armor;

    public Spearman(String name) {
        super(name);
        this.armor = 3;

    }
    public Spearman(){
        super(String.format("Hero_Spearman #%d", ++Spearman.number));
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}