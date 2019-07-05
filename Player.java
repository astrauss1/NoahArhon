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
    public Player(int maxHealth, int level, String name, Weapon basicAttack, int healAmount, Armor[] armor) {
        super(maxHealth, name);
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

    public Player(int maxHealth, int level, String name, Weapon basicAttack, int healAmount) {
        super(maxHealth, name);
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
<<<<<<< HEAD

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
=======
    public Item[] getInventory(){
        return this.inventory;
    }
    public Armor[] getArmor(){
        return this.armor;
>>>>>>> 8ab87cbff3d95bb1b9b00e8f418d85c2f16e93d5
    }
}