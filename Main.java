import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Weapon a = new Weapon("asdf", 10);
        Player b = new Player(50, 1, "Hi", a);
        System.out.println(b.getName());
    }
}
