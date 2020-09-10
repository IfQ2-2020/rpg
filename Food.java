public class Food extends Item
{
    private int Naehrwert;
    
    public Food(int itemID, String pName, String pBeschreibung,int pNaehrwert)
    {
        super(itemID, pName, pBeschreibung);
        Naehrwert = pNaehrwert;
    }
    
    
}
