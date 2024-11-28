package kg.geeks.game.logic;

import kg.geeks.game.template.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    public static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss("Skelet", 1000, 50);

        Warrior warrior1 = new Warrior("Ahiles", 290, 10);
        Warrior warrior2 = new Warrior("Hercules", 280, 15);
        Magic magic = new Magic("Golliaf", 280, 10);
        Berserk berserk = new Berserk("Appolon", 240, 10);
        Medic doc = new Medic("Haus", 250, 5, 15);
        Medic assistant = new Medic("Connor", 300, 5, 5);
        Hacker hacker=new Hacker("Aaron", 350,5);
        King king=new King("Aragorn",330,20);
        Magic magic1=new Magic("Asan", 305,30);
        Bomber bomber=new Bomber("Golum",150,17);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, hacker, king, magic1, bomber};
        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
