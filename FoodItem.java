public class FoodItem extends Item
{
    private int Naehrwert;

    public FoodItem(int itemID, String pName, String pBeschreibung,int p_Naehrwert)

    {
        super(itemID, pName, pBeschreibung);
        Naehrwert = p_Naehrwert;
    }

    public int getNaehrwert()
    {
        return Naehrwert;
    }

    public void setNaehrwert(int p_Naehrwert)
    {
        Naehrwert = p_Naehrwert;
    }
}
