import java.awt.image.BufferedImage;

public class Tile
{
    private int ID;
    private Vector2 position;
    private boolean ueberwindbar = true;
    
    public Tile(int pID, int x, int y) {
        ID = pID;
        position = new Vector2(x, y);
    }

    public Tile(int pID, Vector2 pPosition) {
        ID = pID;
        position = pPosition;
    }
    
    public int getID(){
        return ID;
    }
    
    public BufferedImage getTexture() {
        return Textures.get(this.ID);
    }
    
    public Vector2 getPosition() {
        return position;
    }
    
    public boolean getUeberwindbar(){
        return ueberwindbar;
    }

    public void setUeberwindbar(boolean value) {
        ueberwindbar = value;
    }
}
