public class Enemy extends Entity {
    private Armor[] armor = new Armor[4];
    private int damage;
    public Enemy (int maxHealth, String name, int damage){
        super(maxHealth);
        this.damage=damage;
    }
    public int getDamage(){
        return this.damage;
    }
    public Armor[] getArmor(){
        return this.armor;
    }
}