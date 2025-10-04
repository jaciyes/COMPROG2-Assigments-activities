
class index {
    public static void main(String[] args) {
        Character character = new Character("Naruto", 100, 100, 100);
        Shaman shaman = new Shaman("Sasuke", 150, 100, 100);
        Swordsman swordsman = new Swordsman("Sakura", 170, 100, 100);
        System.out.println("--------------");
        character.walk();
        character.walk();
        character.walk();
        character.run();
        character.run();
        character.ShowStats();
        System.out.println("--------------");
        shaman.walk();
        shaman.walk();  
        shaman.walk();
        shaman.run();
        shaman.run();
        shaman.heal();
        shaman.ShowStats();
        System.out.println("--------------");
        swordsman.walk();
        swordsman.walk();
        swordsman.walk();
        swordsman.run();
        swordsman.run();
        swordsman.slash();
        swordsman.slash();
        swordsman.ShowStats();
        System.out.println("--------------");
    }
}
