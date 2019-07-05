public class Ally extends Entity {
    private Weapon basicAttack;
    private Armor[] armor = {
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0)
    };

    public Ally (int maxHealth, String name, Weapon basicAttack, Armor[] armor) {
        super(maxHealth, name);
        this.basicAttack = basicAttack;
        this.armor = armor;
    }

    public Ally(int maxHealth, String name, Weapon basicAttack) {
        super(maxHealth, name);
        this.basicAttack = basicAttack;
    }

    public Weapon getBasicAttack() {
        return this.basicAttack;
    }
    public Armor[] armor(){
        return this.armor;
    }
}