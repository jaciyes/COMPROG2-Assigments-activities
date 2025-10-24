public class Hunter extends Character {

    public Hunter(String name) {
        super(name, 120, 60, 100);
    }

    @Override
    public void primarySkill(Character target) {
        if (sp < 20) {
            System.out.println("Not enough SP for Power Shot!");
            return;
        }
        sp -= 20;
        int damage = 35;
        target.hp -= damage;
        System.out.println(name + " uses Power Shot! Deals " + damage + " damage!");
    }

    @Override
    public void secondarySkill() {
        if (sp < 10) {
            System.out.println("Not enough SP for Focus!");
            return;
        }
        sp -= 10;
        sp = Math.min(maxSP, sp + 25);
        System.out.println(name + " focuses and restores stamina!");
    }
}
