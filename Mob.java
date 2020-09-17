
/**
 * Beschreiben Sie hier die Klasse Mob.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mob extends NPC
{
    private int agressionlv;
    private int health;
    private int strength;
    private int lootingmass;
    private int[] lootingtable;
    
    

    /**
     * Konstruktor für Objekte der Klasse Mob
     */
    public Mob(int pID,int pSpeed , int[] position, String name, int pAgressionlv, int pHealth, int pStrength, int pLootingmass)
    {
        super(pSpeed, pID, position[0], position[1], position[2], name);
        agressionlv = pAgressionlv;
        health = pHealth;
        strength = pStrength;
        lootingmass = pLootingmass;
        lootingtable = new int[lootingmass];
    }
    public int getLoot(int lootspot){
        return lootingtable[lootspot];
    }
    public void setLoot(int loot, int lootspot){
        lootingtable[lootspot] = loot;
    }

    
}
