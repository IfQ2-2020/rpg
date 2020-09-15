public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;
    private Chunk[] loadedChunks;
    
    
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[5];
        loadFirstChunks();
    }
    
    private void loadFirstChunks(){
        loadedChunks[0] = new Chunk(null,new int[]{0,0}, true);
        loadedChunks[1] = new Chunk(new Chunk[]{null,null,null,loadedChunks[0]},
                                    new int[]{0,16}, false);
        loadedChunks[2] = new Chunk(new Chunk[]{null,null,loadedChunks[0],null},
                                    new int[]{-16,0}, false);
        loadedChunks[3] = new Chunk(new Chunk[]{null,loadedChunks[0],null,null},
                                    new int[]{16,0}, false); 
        loadedChunks[4] = new Chunk(new Chunk[]{loadedChunks[0],null,null,null},
                                    new int[]{0,-16}, false);                            
    }
}
