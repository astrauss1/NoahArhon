package game.objects;

public class Trap {
    private int[] location;
    private String type;
    public Trap(int[] location, String type){
        this.location=location;
        this.type=type;
    }
    public int[] getTrap(){
        return this.location;
    }
    public String getType(){
        return this.type;
    }
}