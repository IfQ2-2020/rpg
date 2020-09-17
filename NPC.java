public class NPC
{
  private int ID;
  private int[] position = new int[3];
  private String name;
  private int speed;
  //private Texture mTexture;


  public NPC(int _ID,int pSpeed, int positionX, int positionY, int direction, String _name){
         ID = _ID;
         position[0] = positionX;
         position[1] = positionY;
         position[2] = direction;
         name = _name;
         speed = pSpeed;
  }
  public void setPosition(int[] sPosition){
    position = sPosition;
  }

    public int[] getPosition(){
        return position;
    }
    public int getPositionX(){
        return position[0];
    }
    public void setPositionX(int pPositionX){
        position[0] = pPositionX;
    }
    public int getPositionY(){
        return position[1];
    }
    public void setPositionY(int pPositionY){
        position[1] = pPositionY;
    }
    public int getDirection(){
        return position[2];
    }
    public void setDirection(int pDirection){
        position[2] = pDirection;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public void laufen(int pDirection)
    {
        if(pDirection >= 0 && pDirection<=4)
        {
        position[2] = pDirection;
            switch (position[2]) {
            case 0: 
            position[1] += speed;    
            break;
            case 1: 
            position[0] += speed; 
            break;
            case 2:
            position[1] -= speed;
            break;
            case 3:
            position[0] -= speed;
            break;
            default: 
            break;
           }
        }
    }
    /*public int getTexture(){
    /*    return Texture.getID();
    }*/
}
