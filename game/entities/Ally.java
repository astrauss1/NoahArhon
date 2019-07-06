package game.entities;

import game.entities.Entity;
import game.items.Weapon;
import game.items.Armor;

public class Ally extends Entity {
    private Weapon basicAttack;
    private Armor[] armor = {
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0)
    };

    public Ally (int maxHealth, String name, int[] location, Weapon basicAttack, Armor[] armor) {
        super(maxHealth, name, location);
        this.basicAttack = basicAttack;
        this.armor = armor;
    }

    public Ally(int maxHealth, String name, int[] location, Weapon basicAttack) {
        super(maxHealth, name, location);
        this.basicAttack = basicAttack;
    }

    public Weapon getBasicAttack() {
        return this.basicAttack;
    }
    public Armor[] armor(){
        return this.armor;
    }
}