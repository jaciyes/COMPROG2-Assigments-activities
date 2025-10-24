import java.util.Scanner;

public class Battleground {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== TEXT-BASED FIGHTING GAME ===");
        Character player = chooseClass();

        while (player.isAlive()) { // game runs until player dies
            Character enemy = createEnemy(player);
            System.out.println("\nA wild " + enemy.name + " appears!");

            // fight loop
            while (player.isAlive() && enemy.isAlive()) {
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

                // enemy turn if still alive
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }

                player.restoreResources();
                enemy.restoreResources();
            }

            if (player.isAlive()) {
                System.out.println("\nYou defeated " + enemy.name + "!");
                player.getPotion();
            } else {
                System.out.println("\nYou have been defeated... Game Over.");
            }
        }
    }

    static Character chooseClass() {
        System.out.println("\nChoose your class:");
        System.out.println("1. Hunter");
        System.out.println("2. Warlock");
        System.out.print("Enter number: ");
        int choice = sc.nextInt();
        if (choice == 2) {
            return new Warlock("Player");
        } else {
            return new Hunter("Player");
        }
    }

    static Character createEnemy(Character player) {
        if (player instanceof Hunter) {
            return new Warlock("Enemy Warlock");
        } else {
            return new Hunter("Enemy Hunter");
        }
    }
}
