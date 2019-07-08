package game.entities;
import game.objects.Block;
import game.objects.Trap;
import game.items.*;
/**
 * The Entity class includes all enemies, allies, bosses, and the player.
 */
public class Entity {
    private int health;
    private int maxHealth;
    private String name;
    private int[] location;
    private int[] prevLoc = new int[2];
    public Entity(int maxHealth, String name, int[] location) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.name = name;
        this.location = location;
        this.prevLoc= prevLoc;
    }

    /**
     * Get the name of the entity.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Take a set amount of damage. 
     * @param damage The amount of damage to take.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    /**
     * Gets the current health of the entity.
     * @return The current health of the entity.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Gets the entity's max health.
     * @return The max health of the entity.
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    /**
     * Heals a certain amount of damage.
     * @param damage The amount of damage to heal.
     */
    public void heal(int damage) {
        this.health += damage;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    /**
     * Gets the location of the entity.
     * @return Location of the enitity.
     */
    public int[] getLocation() {
        return this.location;
    }

    /**
     * Moves the entity to a different location.
     * @param dir a character w, a, s, or d which refers to which direction to move the character. 
     */
    public void move(String dir, Entity entity, Block block, Trap trap) {
        prevLoc[0] = location[0];
        prevLoc[1] = location[1];
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
        if (Entity.sameLocation(entity, block)){
            entity.moveBack();
        }
        if (Entity.sameLocation(entity, trap)){
            if(trap.getType().equalsIgnoreCase("Spikes")){
                int d = 10;
                this.health = this.health-d;
                System.out.println("You have taken " + d + " damage.");
            }
            if(trap.getType().equalsIgnoreCase("Quicksand")){
                //will fill in later
            }
            if(trap.getType().equalsIgnoreCase("Monster spawn")){
                Enemy trapMonster = new Enemy(25, "Trap Monster", entity.getLocation(), new Weapon("Trap Weapon", 5));
            }
        }
    }
    
    /**
     * Moves an entity back to its previous space. 
     * Useful, for instance, in situations where after moving
     * there might be a collision causing you to have to move back.
     */
    public void moveBack() {
        /* We can't just use
         * this.location = this.prevLoc; 
           because then they would both point to 
           the same array so moveBack would do 
           nothing after its first usage */
        

        this.location[0] = this.prevLoc[0];
        this.location[1] = this.prevLoc[1];
    }
    public int[] wall(Entity a, Block b){
        if (sameLocation(a , b) != true){
            a.moveBack();
        }
        return this.location;
    }
    /**
     * Checks if two entities are in the same location. 
     * @param a Any entity to compare the location of.
     * @param b Any to compare the location of.
     * @return Whether the entities are in the same location.
     */
    public static boolean sameLocation(Entity a, Entity b) {
        return (a.getLocation()[0] == b.getLocation()[0] && a.getLocation()[1] == b.getLocation()[1]);
    }
    public static boolean sameLocation(Entity a, Block b){
        return (a.getLocation()[0] == b.getBlock()[0] && a.getLocation()[1] == b.getBlock()[1]);
    }
    public static boolean sameLocation(Entity a, Trap b){
        return (a.getLocation()[0] == b.getTrap()[0] && a.getLocation()[1] == b.getTrap()[1]);
    }
}