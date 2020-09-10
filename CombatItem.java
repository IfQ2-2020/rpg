
/**
 * Beschreiben Sie hier die Klasse Combats.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class CombatItem extends Item
{
    private int durability;
    private int damage;
    private int range;

    public CombatItem(int itemID, String pName, String pDesc, int p_durability, int p_damage, int p_range)
    {
        super(itemID, pName, pDesc);
        durability = p_durability;
        if(p_damage >= 0 && p_damage <=11)
        {
            damage = p_damage;
        }
        if(p_range >= 0)
        {
            range = p_range;
        }
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
        if(p_damage >= 0 && p_damage <=11)
        {
            damage = p_damage;
        }
    }

    public void setRange(int p_range)
    {
        if(p_range >= 0)
        {
            range = p_range;
        }
    }
}
