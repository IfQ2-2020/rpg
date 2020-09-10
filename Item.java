public class Item
{
    private int id;
    private String name;
    private String beschreibung;

    public Item(int p_ID, String p_Name, String p_Beschreibung)
    {
        id = p_ID;
        name = p_Name;
        beschreibung = p_Beschreibung;
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

    // TODO: als textur zurückgeben
    public int getTexture()
    {
        return id;
    }
}