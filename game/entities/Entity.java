package game.entities;

public class Entity {
    private int health;
    private int maxHealth;
    private String name;
    private int MoveSpeed;
    private int[] location;
    public Entity(int maxHealth, String name, int[] location) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.name = name;
        this.MoveSpeed=MoveSpeed;
        this.location = location;
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
    public int getMove(char m){
        return this.MoveSpeed;
    }

    public int[] getLocation() {
        return this.location;
    }

    public void move(String dir) {
        switch (dir) {
            case "w":
                this.location[1] -= 1;
                break;
            case "a":
                this.location[0] -= 1;
                break;
            case "s":
                this.location[1] += 1;
                break;
            case "d":
                this.location[0] += 1;
                break;
        }
    }
}