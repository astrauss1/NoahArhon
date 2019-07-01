public class Player extends Entity {
    private int level;
    private String name;

    public Player(int maxHealth, int level, String name) {
        super(maxHealth);
        this.level = level;
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}