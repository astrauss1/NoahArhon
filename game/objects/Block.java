package game.objects;

public class Block {
    private int[] location;
    public Block(int[] location){
        this.location=location;
    }
    public int[] getBlock(){
        return this.location;
    }
}