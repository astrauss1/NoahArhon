import java.util.Random;
public class Armor{
    private String name;
    private double dmgAbs;
    private int aHealth;
    private double allDmg;
    public Armor (String name, double dmgAbs, int aHealth, double allDmg){
        this.name=name;
        this.dmgAbs=dmgAbs;
        this.aHealth=aHealth;
        this.allDmg=allDmg;
    }
    public String getName(){
        return this.name;
    }
    public double getDmgAbs(){
        double tmp = this.dmgAbs;
        Random rand = new Random();
        if (rand.nextDouble() < this.allDmg) {
            tmp = 0.0;
        }
        return tmp;

    }
    public int getAHealth(){
        return this.aHealth;
    }
}