package kg.geeks.game.template;

public class Bomber extends Hero {
    public Bomber(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.EXPLOSION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() <= 0) {
            System.out.println(this.getName() + " врывается и наносит боссу 100 урона");
            boss.setHealth(boss.getHealth() - 100);
        }
    }
}
