package game.mgmt;

import java.util.Random;
import java.util.Scanner;
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
    public void getRoom(int k){
        String[] arr=new String[10000];
        
        int x=this.width;
        for(int g=0; g<this.length; g++){   
            for(int h=x-this.width; h<x; h++){
                arr[h]="|";
            }
            for(int q=x-this.width; q<x; q++){
                arr[k]="0";
                System.out.print(arr[q]);
            }
            System.out.println("");
            x=x+this.width;
        }
    }
    public int getMove(String uM, int p){
        if(uM.equalsIgnoreCase("w")){
            p=p-this.width;
        }
        if(uM.equalsIgnoreCase("s")){
            p=p+this.width;
        }
        if(uM.equalsIgnoreCase("a")){
            p=p-1;
        }
        if(uM.equalsIgnoreCase("d")){
            p=p+1;
        }
        return p;    
    }     
}