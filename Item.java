import java.awt.image.BufferedImage;

public class Item
{
    private int id;
    private String name;
    private String beschreibung;
    private int textureID;
    private BufferedImage texture;

    public Item(int p_ID, int p_TextureID, String p_Name, String p_Beschreibung)
    {
        id = p_ID;
        textureID = p_TextureID;
        name = p_Name;
        beschreibung = p_Beschreibung;
        texture = Textures.loadFile("./textures/item/" + textureID + ".png");
    }

    public int getID()
    {
        return id;
    }

    public void setID(int p_ID)
    {
        id = p_ID; 
    }

    public String getName()
    {
        return name;
    }

    public void setName(String p_Name)
    {
        name = p_Name; 
    }

    public String getBeschreibung()
    {
        return beschreibung;
    }

    public void setBeschreibung(String p_Beschreibung)
    {
        beschreibung = p_Beschreibung; 
    }
    
    public BufferedImage getTexture() 
    {return texture;}
}