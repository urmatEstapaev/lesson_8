package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.roundNumber <= 4) {
            int boost = 10;
            System.out.println(this.getName() + " увеличил атаку каждого героя " + boost);
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && hero != this) {
                    hero.setDamage(hero.getDamage() + boost);
                    System.out.println(hero.getName() + " теперь имеет уро" + hero.getDamage());
                }
            }
        }
    }
}
