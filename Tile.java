public class Tile
{
    private int ID;
    private boolean ueberwindbar = true;
    
    public Tile(int pID){
        ID = pID;
    }
    
    public int getID(){
        return ID;
    }
    
    /*public getTexture(){
        
    }*/
    
    public boolean getUeberwindbar(){
        return ueberwindbar;
    }
}
