import java.awt.image.BufferedImage;

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
    
    public BufferedImage getTexture() {
        return Textures.get(this.ID);
    }
    
    public boolean getUeberwindbar(){
        return ueberwindbar;
    }
}
