package game.items;

import game.entities.Entity;

public class Weapon{
    private String name;
    private int damage;
    
    public Weapon (String name, int damage){
        this.name=name;
        this.damage=damage;
    }

    public String getName(){
        return this.name;
    }

    public int getDamage(){
        return this.damage;
    }

    public void dealDamage(Entity target) {
        target.takeDamage(this.damage);
    }
}
