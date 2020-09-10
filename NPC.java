public class NPC
{
    private int ID;
    private int[] position = new int[3];
    private String name;
  
    public NPC(int _ID, int[] _position, String _name){
        ID = _ID;
        position = _position;
        name = _name;
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
