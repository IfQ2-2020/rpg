public class Item
{
    private int ID;
    private int Texture;
    private String Name;
    private String Beschreibung;

    public Item(int p_ID, String p_Name, String p_Beschreibung, int p_Texture)
    {
        ID = p_ID;
        Name = p_Name;
        Beschreibung = p_Beschreibung;
        Texture = p_Texture;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int p_ID)
    {
        ID = p_ID; 
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String p_Name)
    {
        Name = p_Name; 
    }

    public String getBeschreibung()
    {
        return Beschreibung;
    }

    public void setBeschreibung(String p_Beschreibung)
    {
        Beschreibung = p_Beschreibung; 
    }

    public int getTexture()
    {
        return Texture;
    }
}