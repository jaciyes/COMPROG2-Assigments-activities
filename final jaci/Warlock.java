public class Warlock extends Character {

    public Warlock(String name) {
        super(name, 100, 120, 80);
    }

    @Override
    public void primarySkill(Character target) {
        if (mp < 25) {
            System.out.println("Not enough MP for Shadow Bolt!");
            return;
        }
        mp -= 25;
        int damage = 40;
        target.hp -= damage;
        System.out.println(name + " casts Shadow Bolt! Deals " + damage + " magic damage!");
    }

    @Override
    public void secondarySkill() {
        if (mp < 20) {
            System.out.println("Not enough MP for Heal!");
            return;
        }
        mp -= 20;
        int heal = 30;
        hp = Math.min(maxHP, hp + heal);
        System.out.println(name + " uses Heal! Restores " + heal + " HP!");
    }
}
