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
    public int getPositionY(){
        return position[1];
    }
    public int getDirection(){
        return position[2];
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }

    /*public int getTexture(){
    /*    return Texture.getID();
    }*/
}
