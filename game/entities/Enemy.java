package game.entities;

import game.entities.Entity;
import game.items.Armor;
import game.items.Weapon;

public class Enemy extends Entity {
    private Armor[] armor = new Armor[4];
    private Weapon attack;
    public Enemy (int maxHealth, String name, Weapon attack, Armor[] armor){
        super(maxHealth, name);
        this.attack = attack;
        this.armor = armor;
    }

    public Enemy (int maxHealth, String name, Weapon attack){
        super(maxHealth, name);
        this.attack=attack;
        this.armor = new Armor[]{
            new Armor("None", 0, 0, 0),
            new Armor("None", 0, 0, 0),
            new Armor("None", 0, 0, 0),
            new Armor("None", 0, 0, 0)
        };
    }

    public Weapon getAttack(){
        return this.attack;
    }

    public Weapon chooseAttack(){
        return this.getAttack();
    }

    public Armor[] getArmor(){
        return this.armor;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(
            armor[0].getModDmg(
                armor[1].getModDmg(
                    armor[2].getModDmg(
                        armor[3].getModDmg(damage)
                    )
                )
            )
        );
    }
}