public class Entity {
    private int health;
    private int maxHealth;
    private String name;
    
    public Entity(int maxHealth, String name) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public void heal(int damage) {
        this.health += damage;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
}