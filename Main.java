import javax.swing.JOptionPane;
import java.util.Scanner;

import game.entities.Player;
import game.entities.Enemy;
import game.items.Weapon;
import game.mgmt.Combat;
import game.mgmt.Location;
import game.entities.Entity;
import game.objects.Block;
import game.objects.Trap;

/**
 * Just the Main class, runs everything.
 */
public class Main {
    public static void main(String[] args) {
        Player b = new Player(50, 1, "hi", new int[]{0, 0}, new Weapon("asdf", 10), 10);
        System.out.println(b.getMaxHealth());
        Enemy a = new Enemy(50, "a", new int[]{2, 4}, new Weapon("stuff", 5));
        Location test = new Location("test", 20, 6);
        Combat doCombat = new Combat();
        Block c = new Block(new int[]{1, 4});
        Scanner userMove = new Scanner(System.in);
        // uM: the letter the user inputs, be it w, a, s, or d.
        String uM;
        while(true){
            test.drawRoom(b, a, c);
            System.out.print("Type wasd: ");
            uM = userMove.nextLine();
            if (!(uM.equals("w") || uM.equals("a") || uM.equals("s") || uM.equals("d"))) {
                break;
            }
            b.move(uM, b, c);
            if (Entity.sameLocation(a, b)){
                doCombat.runBasicFight(b, a);
            }


        }
        userMove.close();
        
    }
}
