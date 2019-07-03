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
    public Player(int maxHealth, int level, String name, Weapon basicAttack, Armor[] armor) {
        super(maxHealth, name);
        this.level = level;
        this.basicAttack = basicAttack;
        this.armor = armor;
    }

    public Player(int maxHealth, int level, String name, Weapon basicAttack) {
        super(maxHealth, name);
        this.level = level;
        this.basicAttack = basicAttack;
    }

    public Weapon getBasicAttack() {
        return this.basicAttack;
    }
    public Item[] getInventory(){
        return this.inventory;
    }
    public Armor[] getArmor(){
        return this.armor;
    }
}