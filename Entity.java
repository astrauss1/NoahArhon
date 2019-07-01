public class Entity {
    private int health;
    private int maxHealth;
    
    public Entity(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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