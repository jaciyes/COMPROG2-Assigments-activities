public class Swordsman extends Character {
   public Swordsman(String name, int health, int stamina, int mana) {
        super(name, health, stamina, mana);
    }
    public void slash() {
       mana += 10;
    }
    @Override
    public void ShowStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Mana: " + mana);
    }
}