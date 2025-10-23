import java.util.*;

public class Warlock extends Character {

    public Warlock(String name) {
        super(name, 100, 130, 80);
    }

    @Override
    public void primarySkill(Character target) {
        if (mp < 30) {
            System.out.println("Not enough MP for Shadow Bolt!");
            return;
        }
        mp -= 30;
        int damage = new Random().nextInt(21) + 30; // 30–50 damage
        target.hp -= damage;
        System.out.println(name + " casts Shadow Bolt! Deals " + damage + " shadow damage and applies a DOT effect!");
    }

    @Override
    public void secondarySkill() {
        if (mp < 40) {
            System.out.println("Not enough MP for Healthstone!");
            return;
        }
        mp -= 40;
        int heal = (int)(maxHP * 0.4);
        hp = Math.min(maxHP, hp + heal);
        System.out.println(name + " uses Healthstone! Restores " + heal + " HP!");
    }
}
