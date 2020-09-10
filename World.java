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
    }
    
    private void loadFirstChunks(){
        loadedChunks[0] = new Chunk(1,null,new int[]{0,0});
        loadedChunks[1] = new Chunk(2, new Chunk[]{loadedChunks[0],null,null,null},
                                    new int[]{0,16});
        loadedChunks[2] = new Chunk(3, new Chunk[]{null,loadedChunks[0],null,null},
                                    new int[]{-16,0});
        loadedChunks[3] = new Chunk(4, new Chunk[]{null,null,loadedChunks[0],null},
                                    new int[]{16,0}); 
        loadedChunks[4] = new Chunk(5, new Chunk[]{null,null,null,loadedChunks[0]},
                                    new int[]{0,-16});                            
    }
}
