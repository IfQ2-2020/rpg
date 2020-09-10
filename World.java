public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;
    private Chunk[] loadedChunks;
    
    
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
    }
    
    private void loadFirstChunks(){
        loadedChunks[0] = new Chunk(1,null);
    }
}
