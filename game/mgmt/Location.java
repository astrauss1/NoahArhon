package game.mgmt;

import java.util.Random;
import java.util.Scanner;
import game.entities.Enemy;
import game.entities.Player;
import game.entities.Entity;
import game.objects.Block;
import game.objects.Trap;
/**
 * Manages information about the current room and draws it
 */
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
    public void drawRoom(Player player, Enemy enemy, Block block, Trap trap){

        for (int y = 0; y < this.length; y++) {
            for (int x = 0; x < this.width; x++) {

                if (x == player.getLocation()[0] && y == player.getLocation()[1]) {
                    System.out.print("A");
                } else if(x == enemy.getLocation()[0] && y == enemy.getLocation()[1]){
                    System.out.print("E");
                } else if(x == trap.getTrap()[0] && y == trap.getTrap()[1]){
                    System.out.print("^");
                } else if(x == block.getBlock()[0] && y == block.getBlock()[1]){
                    System.out.print("!");
                } else {
                    System.out.print(".");
                }
                
            }
            System.out.println();
        }
    }
}