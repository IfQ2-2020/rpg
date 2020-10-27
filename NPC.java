import java.awt.image.BufferedImage;

public class NPC
{
    private int id;
    private String name;
    private Vector2 position;
    private int facingDirection;
    private int speed;
    private BufferedImage mTexture;
    private int textureID;

    public NPC(int pId, int p_TextureID, String pName, int positionX, int positionY, int direction, int pSpeed){
        id = pId;
        textureID = p_TextureID;
        name = pName;
        position  = new Vector2(positionX, positionY);
        facingDirection = direction;
        speed = pSpeed;
        mTexture = Textures.loadFile("./textures/npc/" + textureID + ".png");
    }
  
    public void setPosition(Vector2 sPosition){
        position = sPosition;
    }

    public Vector2 getPosition(){
        return position;
    }
    
    public int getDirection(){
        return facingDirection;
    }
    
    public void setDirection(int pDirection){
        facingDirection = pDirection;
    }
    
    public String getName(){
        return name;
    }
    
    public BufferedImage getTexture(){
        return mTexture;
    }
    
    public int getID(){
        return id;
    }
    
    public void laufen(int pDirection)
    {
        if(pDirection >= 0 && pDirection<=4)
        {
            facingDirection = pDirection;
            switch (facingDirection) {
                case 0:
                    position = position.subtract(new Vector2(0, speed));
                    break;
                case 1: 
                    position = position.add(new Vector2(speed, 0));
                    break;
                case 2:
                    position = position.add(new Vector2(0, speed));
                    break;
                case 3:
                    position = position.subtract(new Vector2(speed, 0));
                    break;
           }
        }
    }
}
