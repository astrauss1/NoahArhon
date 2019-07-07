package game.mgmt;

import javax.swing.JOptionPane;

import game.entities.Player;
import game.entities.Enemy;
import game.entities.Boss;
import game.items.Weapon;

public class Combat {
    private Player player;
    private Enemy enemy;
    private Boss boss;
    private boolean combatActive = false;
    private String loser;
    private boolean ran = false;
    
    public Combat() {}

    private int promptB(String prompt, String title, String[] options, int defaultIndex) {
        return JOptionPane.showOptionDialog(
            null,
            prompt,
            title,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[defaultIndex]
        );
    }

    private void runBasicTurn() {
        boolean heal = false;
        int tmpPD = player.getHealth();
        int tmpED = enemy.getHealth();

        String choice = new String[]{
            "Run", 
            /*"Item",*/ 
            "Heal", 
            /*"Ability", */
            "Attack"
        }[this.promptB(
            "What do you want to do?", 
            "Moves", 
            new String[]{
                "Run", 
                /*"Item",*/ 
                "Heal", 
                /*"Ability", */
                "Attack"
            }, 
            0
        )];
        
        if            ("Run".equals(choice)) {
            this.combatActive = false;
            this.ran = true;
        } else if    ("Item".equals(choice)) {
            // TODO: MAKE ITEMS
        } else if ("Ability".equals(choice)) {
            // TODO: MAKE ABILITIES
        } else if    ("Heal".equals(choice)) {
            heal = true;
        } else if  ("Attack".equals(choice)) {
            String[] attacksStr = new String[4];
            for (int i = 0; i < 4; i++) {
                attacksStr[i] = player.getAttacks()[i].getName();
                
            }

            Weapon playerAttack = player.getAttacks()[this.promptB("Please choose an attack:", "Attacks", attacksStr, 0)];
            System.out.println(playerAttack.getName());
            Weapon enemyAttack = enemy.chooseAttack();
            System.out.println(enemyAttack.getName());

            playerAttack.dealDamage(enemy);
            enemyAttack.dealDamage(player);

            tmpPD -= player.getHealth();
            tmpED -= enemy.getHealth();

            JOptionPane.showMessageDialog(
                null,
                "You used " + 
                playerAttack.getName() +
                " and did " + 
                tmpED + 
                " damage. \n" +
                "Your opponent used " +
                enemyAttack.getName() +
                " and did " +
                tmpPD +
                " damage. \n" +
                "You have " +
                player.getHealth() +
                " health, and your opponent has " +
                enemy.getHealth() +
                " health."
            );

        } else {
            JOptionPane.showMessageDialog(
                null,
                "What... How did you mess this up? Just play the game, for God's sake!"
            );
        }

        if (heal) {
            Weapon enemyAttack = enemy.chooseAttack();
            System.out.println(enemyAttack.getName());
            enemyAttack.dealDamage(player);

            tmpPD -= player.getHealth();

            JOptionPane.showMessageDialog(
                null,
                "You used heal and healed" +
                player.getHealAmount() + 
                " damage. \n" +
                "Your opponent used " +
                enemyAttack.getName() +
                " and did " +
                tmpPD +
                " damage. \n" +
                "You have " +
                (player.getHealth() + player.getHealAmount()) + 
                " health, and your opponent has " +
                enemy.getHealth() +
                " health."
            );
            player.moveHeal();
        }
    }

    public void runBasicFight(Player p, Enemy e) {

        this.player = p;
        this.enemy = e;

        this.combatActive = true;
        int startHealth = player.getHealth();
        
        do {
            runBasicTurn();
            if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
                this.combatActive = false;
            }
        } while (this.combatActive);

        if (player.getHealth() <= 0) {
            this.loser = "Player";
        } else {
            this.loser = enemy.getName();
        }

        if (ran) {
            JOptionPane.showMessageDialog(
                null,
                "You ran away. You lost " + 
                Integer.toString(startHealth - player.getHealth()) + 
                " health during this fight."
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "You lost " + 
                Integer.toString(startHealth - player.getHealth()) + 
                " health during this fight. The loser was the " + 
                this.loser + 
                "."
            );
        }
        player.moveBack();
        ran = false;
        this.player = null;
        this.enemy = null;
    }
    public boolean getCombat(){
        return this.combatActive;
    }
}