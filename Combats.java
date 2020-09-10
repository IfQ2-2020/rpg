
/**
 * Beschreiben Sie hier die Klasse Combats.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Combats extends Item
{
    private int durability;
    private int damage;
    private int range;

    public Combats(int p_durability, int p_damage, int p_range)
    {
        durability = p_durability;
        damage = p_damage;
        range = p_range;
    }

    public int getDurability()
    {
       return durability;
    }
    
    public int getDamage()
    {
       return damage;
    }
    
    public int getRange()
    {
       return range;
    }
    
    public void setDurability(int p_durability)
    {
        durability = p_durability;
    }
    
    public void setDamage(int p_damage)
    {
        damage = p_damage;
    }
    
    public void setRange(int p_range)
    {
        range = p_range;
    }
}
