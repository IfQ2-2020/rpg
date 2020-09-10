public class NPC
{
  private int ID;
  private int[] position = new int[3];
  private String name;
  //private Texture mTexture;
  
  public NPC(int _ID, int[] _position, String _name){
         ID = _ID;
         position = _position;
         name = _name;
  }
  public void getTexture(){
         //return Texture.ID
  }
  public int[] getPosition(){
        return position;
  }
  public int[] setPosition(int[] sPosition){
    position = sPosition
    }
  public String getName(){
        return name;}
  public int getID(){
        return ID;}

  
  /*public int getTexture(){
         return Texture.getID();
  }*/
}
