package game.mgmt;

import java.util.Random;
import java.util.Scanner;
import game.entities.Enemy;
import game.entities.Player;

public class Location{
    private String type;
    private int width;
    private int length;
    public Location(String type, int width, int length){
        this.type=type;
        this.width=width;
        this.length=length;
    }
    public String getType(){
        return this.type;
    }
    public void drawRoom(Player player, Enemy enemy){
        for (int y = 0; y < this.length; y++) {
            for (int x = 0; x < this.width; x++) {
                if (x == player.getLocation()[0] && y == player.getLocation()[1]) {
                    System.out.print("A");
                } else if(x == enemy.getLocation()[0] && y == enemy.getLocation()[1]){
                    System.out.print("E");
                } else {
                    System.out.print("|");
                }

            }
            System.out.println();
        }
    }
}