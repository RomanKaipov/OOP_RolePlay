import Units.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();
    public static ArrayList<BaseHero> holyTeam = new ArrayList<>();
    public static ArrayList<BaseHero> darkTeam = new ArrayList<>();
    public static ArrayList<BaseHero> allTeam = new ArrayList<>();
    static int teamCount = 10;

    public static void main(String[] args) {
//        holyTeam = createTeam(teamCount,0);
//        darkTeam = createTeam(teamCount,9);
        createTeams(teamCount);

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        allTeam.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (true) {

            View.view();
            scanner.nextLine();
            int summ1HP = 0;
            int summ2HP = 0;
            for (BaseHero hero : holyTeam) {
                summ1HP += hero.getHp();
            }
            for (BaseHero hero : darkTeam) {
                summ2HP += hero.getHp();
            }
            if (summ1HP == 0) {
                System.out.println("Победила команда darkTeam");
                flag = false;
                break;
            }
            if (summ2HP == 0) {
                System.out.println("Победила команда holyTeam");
                flag = false;
                break;
            }
            for (BaseHero hero : allTeam) {
                if (holyTeam.contains(hero)) hero.step(darkTeam, holyTeam);
                else hero.step(holyTeam, darkTeam);
            }

        }
    }



private static String generateName() {
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


static void createTeams(int teamCount) {
    for (int i = 0; i <= teamCount; i++) {
        BaseHero holyHero = getRandomHero(random.nextInt(7), i, 1);
        BaseHero darkHero = getRandomHero(random.nextInt(7), i, 10);
        holyTeam.add(holyHero);
        darkTeam.add(darkHero);
    }
}

static BaseHero getRandomHero(int choice, int x, int y) {
    switch (choice) {
        case 0:
            return new Crossbowman(generateName(), x, y);
        case 1:
            return new Magician(generateName(), x, y);
        case 2:
            return new Monk(generateName(), x, y);
        case 3:
            return new Peasant(generateName(), x, y);
        case 4:
            return new Rogue(generateName(), x, y);
        case 5:
            return new Sniper(generateName(), x, y);
        case 6:
            return new Spearman(generateName(), x, y);
        default:
            return null;
    }
}


}


