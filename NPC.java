import java.awt.image.BufferedImage;

public class NPC
{
    private int generalID;
    private int specialID;
    private Vector2 position;
    private int facingDirection;
    private String name;
    private int speed;
    private BufferedImage mTexture;

    public NPC(String _name, int genID, int speID, int pSpeed, int positionX, int positionY, int direction){
        generalID = genID;
        specialID = speID;
        position  = new Vector2(positionX, positionY);
        facingDirection = direction;
        name = _name;
        speed = pSpeed;
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
    
    public int getGenID(){
        return generalID;
    }
    
    public int getSpeID(){
        return specialID;
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
