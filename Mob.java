public class Mob extends NPC
{
    private int agressionlv;
    private int health;
    private int strength;
    private int lootingmass;
    private int[] lootingtable;
    private int[] lootposs;
    
    /**
     * Konstruktor für Objekte der Klasse Mob
     */
    public Mob(int id, String pName, int x, int y, int direction, int pSpeed, 
        int lootId5, int lootId4, int lootId3, int lootId2, int lootId1, 
        int pAggressionlv, int pHealth, int pStrength, int pLootingmass, int p_TextureID)
    {
        super(id, p_TextureID, pName, x, y, direction, pSpeed);
        agressionlv = pAggressionlv;
        health = pHealth;
        strength = pStrength;
        lootingmass = pLootingmass;
        lootingtable = new int[lootingmass];
        lootposs = new int[5];
        lootposs[0] = lootId1;
        lootposs[1] = lootId2;
        lootposs[2] = lootId3;
        lootposs[3] = lootId4;
        lootposs[4] = lootId5;
    }
    public void lootSteup(){
        for(int i = 0; i < lootingmass ; i++){
            int loot = lootposs[possibles()];
            lootingtable[i] = loot;
        }
    }
    
    public int possibles(){
        double possible = Math.random()*5;
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
    public void sethealth(int pHealth){
        health = pHealth;
    }
    
    
}
