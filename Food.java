public class Food extends Item
{
    private int Naehrwert;

    public Food(int p_Naehrwert)
    {
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
