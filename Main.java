import javax.swing.JOptionPane;
import java.util.Scanner;

import game.entities.Player;
import game.entities.Enemy;
import game.items.Weapon;
import game.mgmt.Combat;
import game.mgmt.Location;

public class Main {
    public static void main(String[] args) {
        Player b = new Player(50, 1, "hi", new int[]{0, 0}, new Weapon("asdf", 10), 10);
        Enemy a = new Enemy(50, "a", new int[]{2, 4}, new Weapon("stuff", 10));
        Location test = new Location("test", 20, 6);

        Scanner userMove = new Scanner(System.in);
        String uM;
        while(true){
            test.drawRoom(b, a);
            System.out.print("Type wasd: ");
            uM = userMove.nextLine();
            if (!(uM.equals("w") || uM.equals("a") || uM.equals("s") || uM.equals("d"))) {
                break;
            }
            b.move(uM);
            if (a.getLocation()[0]==b.getLocation()[0] && a.getLocation()[1]==b.getLocation()[1]){
                Combat what = new Combat(b, a);
                what.runBasicFight();
            }
        }
        userMove.close();
        
    }
}
