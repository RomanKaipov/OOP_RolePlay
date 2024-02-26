import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static ArrayList<BaseHero> teamOne = new ArrayList<>();
    static ArrayList<BaseHero> teamTwo = new ArrayList<>();
    static int teamCount = 10;

    public static void main(String[] args) {

        for (int i = 0; i < teamCount; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1:
                    teamOne.add(new Monk(GetName(), i, 0));
                    break;
                case 2:
                    teamOne.add(new Magician(GetName(), i, 0));
                    break;
                case 3:
                    teamOne.add(new Crossbowman(GetName(), i, 0));
                    break;
                case 4:
                    teamOne.add(new Sniper(GetName(), i, 0));
                    break;
                case 5:
                    teamOne.add(new Peasant(GetName(), i, 0));
                    break;
                case 6:
                    teamOne.add(new Rogue(GetName(), i, 0));
                    break;
                case 7:
                    teamOne.add(new Spearman(GetName(), i, 0));
                    break;
            }
        }

        for (int i = 0; i < teamCount; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1:
                    teamTwo.add(new Monk(GetName(), i, 9));
                    break;
                case 2:
                    teamTwo.add(new Magician(GetName(), i, 9));
                    break;
                case 3:
                    teamTwo.add(new Crossbowman(GetName(), i, 9));
                    break;
                case 4:
                    teamTwo.add(new Sniper(GetName(), i, 9));
                    break;
                case 5:
                    teamTwo.add(new Peasant(GetName(), i, 9));
                    break;
                case 6:
                    teamTwo.add(new Rogue(GetName(), i, 9));
                    break;
                case 7:
                    teamTwo.add(new Spearman(GetName(), i, 9));
                    break;
            }
        }
        printTeamsInfo(teamOne, teamTwo);
    }

    private static String GetName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    public static void printTeamsInfo(ArrayList<BaseHero> teamOne, ArrayList<BaseHero> teamTwo) {
        for (BaseHero hero : teamOne) {
            if (hero instanceof Crossbowman) {
                System.out.println(String.format("%s %s", (Crossbowman) hero, ((Crossbowman) hero).FindEnemy(teamTwo)));
            } else {
                System.out.println(hero);
            }
        }
        for (BaseHero hero : teamTwo) {
            if (hero instanceof Crossbowman) {
                System.out.println(String.format("%s %s", (Crossbowman) hero, ((Crossbowman) hero).FindEnemy(teamOne)));
            } else {
                System.out.println(hero);
            }
        }
    }
}


