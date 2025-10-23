import java.util.*;

public class Hunter extends Character {

    public Hunter(String name) {
        super(name, 110, 60, 120);
    }

    @Override
    public void primarySkill(Character target) {
        if (sp < 30) {
            System.out.println("Not enough SP for Aimed Shot!");
            return;
        }
        sp -= 30;
        int damage = new Random().nextInt(16) + 35; // 35–50 damage
        target.hp -= damage;
        System.out.println(name + " uses Aimed Shot! Deals " + damage + " powerful damage!");
    }

    @Override
    public void secondarySkill() {
        if (sp < 30) {
            System.out.println("Not enough SP for Deflect!");
            return;
        }
        sp -= 30;
        defending = true;
        System.out.println(name + " uses Deflect! Greatly increases dodge chance for 3 turns!");
    }
}
