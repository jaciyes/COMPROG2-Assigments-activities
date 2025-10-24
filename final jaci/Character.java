import java.util.Scanner;

public abstract class Character {
    protected String name;
    protected int maxHP, hp, maxMP, mp, maxSP, sp;
    protected int healingPotions = 1;
    protected int manaPotions = 1;
    protected boolean defending = false;

    public Character(String name, int hp, int mp, int sp) {
        this.name = name;
        this.maxHP = hp;
        this.hp = hp;
        this.maxMP = mp;
        this.mp = mp;
        this.maxSP = sp;
        this.sp = sp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void attack(Character target) {
        if (sp < 2) {
            System.out.println(name + " doesn’t have enough SP to attack!");
            return;
        }
        sp -= 2;
        int damage = 15; // fixed damage for simplicity
        if (target.defending) {
            damage = damage / 2;
        }
        target.hp -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
    }

    public void defend() {
        if (sp < 3) {
            System.out.println(name + " doesn’t have enough SP to defend!");
            return;
        }
        sp -= 3;
        defending = true;
        System.out.println(name + " is defending and takes reduced damage next turn!");
    }

    public void useItem(Scanner sc) {
        System.out.println("\n-- Use Item --");
        System.out.println("1. Healing Potion (" + healingPotions + ")");
        System.out.println("2. Mana Potion (" + manaPotions + ")");
        System.out.print("Choose: ");
        int choice = sc.nextInt();

        if (choice == 1 && healingPotions > 0) {
            int heal = 40;
            hp = Math.min(maxHP, hp + heal);
            healingPotions--;
            System.out.println(name + " healed for " + heal + " HP!");
        } else if (choice == 2 && manaPotions > 0) {
            int restore = 30;
            mp = Math.min(maxMP, mp + restore);
            manaPotions--;
            System.out.println(name + " restored " + restore + " MP!");
        } else {
            System.out.println("No potions or invalid choice!");
        }
    }

    public void getPotion() {
        if (Math.random() < 0.5) {
            healingPotions++;
            System.out.println("You got a Healing Potion!");
        } else {
            manaPotions++;
            System.out.println("You got a Mana Potion!");
        }
    }

    public void restoreResources() {
        sp = Math.min(maxSP, sp + 5);
        defending = false;
    }

    public abstract void primarySkill(Character target);
    public abstract void secondarySkill();

    public void showStats() {
        System.out.printf("%s HP:%d/%d MP:%d/%d SP:%d/%d\n",
            name, hp, maxHP, mp, maxMP, sp, maxSP);
    }
}
