public class Ability {
    private int damage;
    private double dmgMult;
    private double dmgRed;
    private String name;
    public Ability(String name, int damage, double dmgMult, double dmgRed){
        this.name=name;
        this.damage=damage;
        this.dmgMult=dmgMult;
        this.dmgRed=dmgRed;
    }
    public String getName(){
        return this.name;
    }
    public int getDmgMult(int damage){
        double tmp=this.dmgMult;
        return(int)(tmp*damage);
    }
    public int getDmgRed(int damage){
        double tmp=this.dmgRed;
        return(int)(tmp*damage);
    }
    public int getDamage(){
        return this.damage;
    }
}
