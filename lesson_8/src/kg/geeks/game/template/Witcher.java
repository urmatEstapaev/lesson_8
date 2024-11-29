package kg.geeks.game.template;


public class Witcher extends Hero {
    public Witcher(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.REVIVE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (!hero.isAlive() && hero != this) {
                revive(hero);
                break;
            }
        }
    }

    public void revive(Hero hero) {
        if (this.isAlive() && !hero.isAlive()) {
            hero.setHealth(200);
            this.setHealth(0);
            System.out.println("Witcher revived " + hero.getName() + " but died!!!");
        }
    }
}