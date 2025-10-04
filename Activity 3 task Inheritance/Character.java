public class Character {
    String name;
    int health;
    int stamina;
    int mana;

    public Character(String name, int health, int stamina, int mana) {
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.mana = mana;
    }
    
    public void run() {
        stamina -= 3;
    }

    public void walk() {
        stamina -= 1;
    }
    public void ShowStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Mana: " + mana);
    }


}