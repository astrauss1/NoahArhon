package game.effects;



public class Ability {
    private int damage;
    private double dmgMult;
    private double dmgRed;
    private String name;
    private int turnsActive;
    private int turnsLeft = 0;

    public Ability(String name, int damage, double dmgMult, double dmgRed, int turnsActive){
        this.name=name;
        this.damage = damage;
        this.dmgMult = dmgMult;
        this.dmgRed = dmgRed;
        this.turnsActive = turnsActive;
    }
    public String getName(){
        return this.name;
    }
    public int getDmgMult(int damage){
        double tmp=this.dmgMult;
        return(int)(tmp * damage);
    }
    public int getDmgRed(int damage){
        double tmp=this.dmgRed;
        return(int)((1 - tmp) * damage);
    }
    public int getDamage(){
        return this.damage;
    }
    public void activateAbility() {
        this.turnsLeft = this.turnsActive;
    }
    public void decrementTurn() {
        if (this.turnsLeft > 0) {
            this.turnsLeft -= 1;
        }
    }
}
