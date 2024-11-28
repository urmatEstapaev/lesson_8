package kg.geeks.game.template;

import java.util.Random;

public class Hacker extends Hero {
    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACKING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int random1 = new Random().nextInt(heroes.length);
        int random2 = new Random().nextInt(100);
        boss.setHealth(boss.getHealth() - random2);
        heroes[random1].setHealth(heroes[random1].getHealth() + random2);
        System.out.println(this.getName() + " украл " + random2 + " здоровье у босса и передал герою " + heroes[random1].getName());
    }
}
