package game.entities;

import game.entities.Entity;
import game.items.Armor;
import game.items.Weapon;
import game.items.Item;

public class Player extends Entity {
    private int level;
    private Weapon basicAttack;
    private Armor[] armor = {
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0), 
        new Armor("None", 0, 0, 0)
    };
    private Item[] inventory = {
        new Item("None"),
        new Item("None"),
        new Item("None"),
        new Item("None"),
        new Item("None"),
        new Item("None"),
        new Item("None"),
        new Item("None")
    };
    private int healAmount;
    private Weapon[] attacks;

    public Player(int maxHealth, int level, String name, int[] location, Weapon basicAttack, int healAmount, Armor[] armor) {
        super(maxHealth, name, location);
        this.level = level;
        this.basicAttack = basicAttack;
        this.armor = armor;
        this.healAmount = healAmount;
        this.attacks = new Weapon[]{
            basicAttack, 
            new Weapon("None", 0),
            new Weapon("None", 0),
            new Weapon("None", 0)
        };
    }

    public Weapon[] getAttacks() {
        return this.attacks;
    }

    public Player(int maxHealth, int level, String name, int[] location, Weapon basicAttack, int healAmount) {
        super(maxHealth, name, location);
        this.level = level;
        this.basicAttack = basicAttack;
        this.healAmount = healAmount;
        this.attacks = new Weapon[]{
            basicAttack, 
            new Weapon("None", 0),
            new Weapon("None", 0),
            new Weapon("None", 0)
        };
    }

    public Weapon getBasicAttack() {
        return this.basicAttack;
    }

    public void moveHeal() {
        this.heal(this.healAmount);
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(
            armor[0].getModDmg(
                armor[1].getModDmg(
                    armor[2].getModDmg(
                        armor[3].getModDmg(damage)
                    )
                )
            )
        );
    }
    public Item[] getInventory(){
        return this.inventory;
    }
    
    public Armor[] getArmor(){
        return this.armor;
    }
}