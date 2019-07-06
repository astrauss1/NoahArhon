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
        Location test = new Location("test", 20, 6);

        Scanner userMove = new Scanner(System.in);
        String uM;
        while(true){
            test.drawRoom(b);
            System.out.print("Type wasd: ");
            uM = userMove.nextLine();
            if (!(uM.equals("w") || uM.equals("a") || uM.equals("s") || uM.equals("d"))) {
                break;
            }
            b.move(uM);
        }
        userMove.close();
    }
}
