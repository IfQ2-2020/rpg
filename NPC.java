public class NPC
{
  private int ID;
  private int[] position = new int[3];
  private String name;
  //private Texture mTexture;


  public NPC(int _ID, int position1, int position2, int direction, String _name){
         ID = _ID;
         position[0] = position1;
         position[1] = position2;
         position[2] = direction;
         name = _name;
  }
  public void setPosition(int[] sPosition){
    position = sPosition;
  }

    public int[] getPosition(){
        return position;
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
