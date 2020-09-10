
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
        damage = p_damage;
        range = p_range;
    }
}
