public class Food extends Item
{
    private int Naehrwert;
<<<<<<< HEAD

    public Food(int p_Naehrwert)
=======
    
    public Food(int itemID, String pName, String pBeschreibung,int pNaehrwert)
>>>>>>> 7eea9b2d7b90b632ccef3b22ff88e5d6470c2058
    {
<<<<<<< HEAD
        Naehrwert = p_Naehrwert;
=======
        super(itemID, pName, pBeschreibung);
        Naehrwert = pNaehrwert;
>>>>>>> 7eea9b2d7b90b632ccef3b22ff88e5d6470c2058
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
