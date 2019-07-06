import javax.swing.JOptionPane;
import java.util.Scanner;

import game.entities.Player;
import game.entities.Enemy;
import game.items.Weapon;
import game.mgmt.Combat;

public class Main {
    public static void main(String[] args) {
        Player b = new Player(50, 1, "hi", new Weapon("asdf", 10), 10);
        System.out.println(b.getName());
        Location test = new Location("test", 20, 6);
        Scanner userMove = new Scanner(System.in);
        int p=10;
        Combat asdf = new Combat(b, new Enemy(50, "whatever", new Weapon("Stuff", 5)));
        while(asdf.getCombat()!=true){
            System.out.print("please enter wasd");
            String uM=userMove.next();
            int k=test.getMove(uM, p);
            test.getRoom(k);
            p=k;

        }
        userMove.close();
        System.out.println(b.getAttacks().length);
        asdf.runBasicFight();

    }
}
