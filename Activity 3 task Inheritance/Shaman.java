
public class Shaman extends Character {
    public Shaman(String name, int health, int stamina, int mana) {
        super(name, health, stamina, mana);
    }
    public void heal() {
       health += 5;
       stamina += 5;
       mana += 5;
    }
    
}
