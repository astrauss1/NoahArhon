import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Player b = new Player(50, 1, "Hi", new Weapon("asdf", 10), 10);
        
        System.out.println(b.getAttacks().length);

        Combat asdf = new Combat(b, new Enemy(50, "whatever", new Weapon("Stuff", 5)));
        asdf.runBasicFight();
    }
}
