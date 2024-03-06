import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {
    static Random random = new Random();

    static int teamCount = 10;

    public static void main(String[] args) {

        ArrayList<BaseHero> teamOne = new ArrayList<>();
        ArrayList<BaseHero> teamTwo = new ArrayList<>();
        BaseHero Crossbowman = new Crossbowman("Crossbowman", 7,7);
        BaseHero Rogue = new Rogue("Rogue", 2,5);
        BaseHero Monk = new Monk("Monk", 3,6);
        teamOne.add(Crossbowman);
        teamTwo.add(Monk);
        teamTwo.add(Rogue);
        System.out.println(Rogue.coordinates);
        Rogue.step(teamOne,teamTwo);
        System.out.println(Rogue.coordinates);
        Rogue.step(teamOne,teamTwo);
        System.out.println(Rogue.coordinates);







    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    public static void printTeamsInfo(ArrayList<BaseHero> teamOne, ArrayList<BaseHero> teamTwo) {
        System.out.println("~~~~~~~~~TeamOne~~~~~~~~~");
        for (BaseHero hero : teamOne) {
                System.out.println(hero);
        }
        System.out.println("~~~~~~~~~TeamTwo~~~~~~~~~");
        for (BaseHero hero : teamTwo) {
                System.out.println(hero);
        }
    }
    public static ArrayList<BaseHero> createTeam(int teamCount){
        ArrayList<BaseHero> team = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1:
                    team.add(new Monk(getName(), i, 0));
                    break;
                case 2:
                    team.add(new Magician(getName(), i, 0));
                    break;
                case 3:
                    team.add(new Crossbowman(getName(), i, 0));
                    break;
                case 4:
                    team.add(new Sniper(getName(), i, 0));
                    break;
                case 5:
                    team.add(new Peasant(getName(), i, 0));
                    break;
                case 6:
                    team.add(new Rogue(getName(), i, 0));
                    break;
                case 7:
                    team.add(new Spearman(getName(), i, 0));
                    break;
            }
        }
        return team;
    }


}


