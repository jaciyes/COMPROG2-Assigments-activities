import java.util.*;

public class Battleground {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("=== TEXT-BASED FIGHTING GAME ===");
        Character player = chooseClass();
        int score = 0, difficulty = 1;

        while (player.isAlive()) {
            Character enemy = createEnemy(player);
            System.out.println("\nA wild " + enemy.name + " appears! (Difficulty " + difficulty + ")");

            while (player.isAlive() && enemy.isAlive()) {
                System.out.println();
                player.showStats();
                enemy.showStats();
                System.out.println("\n1. Attack\n2. Defend\n3. Use Item\n4. Primary Skill\n5. Secondary Skill");
                System.out.print("Choose: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> player.attack(enemy);
                    case 2 -> player.defend();
                    case 3 -> player.useItem(sc);
                    case 4 -> player.primarySkill(enemy);
                    case 5 -> player.secondarySkill();
                    default -> System.out.println("Invalid choice!");
                }

                if (enemy.isAlive()) {
                    if (rand.nextDouble() < 0.7)
                        enemy.attack(player);
                    else
                        enemy.defend();
                }

                player.restoreResources();
                enemy.restoreResources();
            }

            if (player.isAlive()) {
                System.out.println("\nYou defeated " + enemy.name + "!");
                dropPotion(player);
                score++;
                difficulty++;
                player.hp = Math.min(player.maxHP, player.hp + 20);
                player.sp = Math.min(player.maxSP, player.sp + 20);
            } else {
                System.out.println("\nYou have been defeated... Game Over.");
            }
        }

        System.out.println("Final Score: " + score);
    }

    static Character chooseClass() {
        System.out.println("\nChoose your class:");
        System.out.println("1. Hunter");
        System.out.println("2. Warlock");
        System.out.print("Enter number: ");
        int choice = sc.nextInt();
        return (choice == 2) ? new Warlock("Player") : new Hunter("Player");
    }

    static Character createEnemy(Character player) {
        if (player instanceof Hunter) {
            return new Warlock("Enemy Warlock");
        } else {
            return new Hunter("Enemy Hunter");
        }
    }

    static void dropPotion(Character player) {
        String potion = rand.nextBoolean() ? "Healing" : "Mana";
        if (potion.equals("Healing"))
            player.healingPotions++;
        else
            player.manaPotions++;
        System.out.println("The enemy dropped a " + potion + " Potion!");
    }
}
