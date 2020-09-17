
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
        //lootingmass = reale Lootanzahl -1
        lootingtable = new int[lootingmass];
    }
    public void lootSteup(){
        for(int i = 0; i < lootingmass ; i++){
            int loot = posibles();
            lootingtable[i] = loot;
        }
    }
    public int posibles(){
        double possible = Math.random()*10;
        return (int)possible;
    }
    public int getLoot(int lootspot){
        return lootingtable[lootspot];
    }
    public void setLoot(int loot, int lootspot){
        lootingtable[lootspot] = loot;
    }
    public int getStrength(){
        return strength;
    }
    public int getHealth(){
        return health;
    }
    
    
}
