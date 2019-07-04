import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String pName=JOptionPane.showInputDialog(null, "Please enter your name");
        Weapon basicSword = new Weapon("Basic Sword", 10);
        Player a = new Player(50, 1, pName, basicSword);
        System.out.println(a.getName());
    }
}
