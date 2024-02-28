import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {
    static Random random = new Random();

    static int teamCount = 10;

    public static void main(String[] args) {

        ArrayList<BaseHero> teamOne = createTeam(teamCount);
        ArrayList<BaseHero> teamTwo = createTeam(teamCount);
        System.out.println("До сортировки\n");
        printTeamsInfo(teamOne, teamTwo);
        teamOne.sort(Comparator.comparingInt(BaseHero::getInitiative).reversed());
        teamTwo.sort(Comparator.comparingInt(BaseHero::getInitiative).reversed());
        System.out.println("\nПосле сортировки\n");
        printTeamsInfo(teamOne, teamTwo);

//        ArrayList<BaseHero> teamOne = new ArrayList<>();
//        ArrayList<BaseHero> teamTwo = new ArrayList<>();
//        BaseHero hero1 = new Crossbowman("God", 1,1);
//        BaseHero hero2 = new Peasant("Target", 0,1);
//        teamOne.add(hero1);
//        teamTwo.add(hero2);
//        printTeamsInfo(teamOne, teamTwo);
//        hero1.step(teamTwo);
//        printTeamsInfo(teamOne, teamTwo);
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    public static void printTeamsInfo(ArrayList<BaseHero> teamOne, ArrayList<BaseHero> teamTwo) {
        System.out.println("~~~~~~~~~TeamOne~~~~~~~~~");
        for (BaseHero hero : teamOne) {
            if (hero instanceof Crossbowman) {
                System.out.println(String.format("%s My nearest enemy is %s", (Crossbowman) hero, ((Crossbowman) hero).findEnemy(teamTwo)));
            } else {
                System.out.println(hero);
            }
        }
        System.out.println("~~~~~~~~~TeamTwo~~~~~~~~~");
        for (BaseHero hero : teamTwo) {
            if (hero instanceof Crossbowman) {
                System.out.println(String.format("%s My nearest enemy is %s", (Crossbowman) hero, ((Crossbowman) hero).findEnemy(teamOne)));
            } else {
                System.out.println(hero);
            }
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


