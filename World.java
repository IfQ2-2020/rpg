public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;
    private int seed;

    /* Die vom localPlayer geladenen Chunks
    0  1  2
    3 (4) 5 // 4 auf den Spieler zentriert
    6  7  8
     */
    private Chunk[] loadedChunks;
    private Vector2 dimensions = new Vector2(800,800);
    public Spieler localPlayer;
    
    WorldGeneration test;
    public World(int pSeed)
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[9];
        localPlayer = new Spieler("OK",1,400,400,0,1,this);
        seed = pSeed;
        //Vorest
        test = new WorldGeneration(dimensions.getX(),dimensions.getY(),seed);
        try {
            test.generateHeightmap();
        } catch (Exception e) {
            System.out.println(e);
        }
        loadNextChunks();
    }

    public Vector2 getDimensions(){
        return dimensions;
    }
    
    public Spieler getLocalPlayer() {
        return localPlayer;
    }
    
    public Chunk[] getLoadedChunks() {
        return loadedChunks;
    }

    public void loadNextChunks() {
        Vector2 pos = localPlayer.getPosition();
        //....
        // Um chunk size teilen um die rel chunk pos zu bekommen
        Vector2 chunkPos = pos.divBy(16);
        
        Chunk[] newChunks = new Chunk[9];
        
        int i = 0;
        for (int y = chunkPos.getY() - 1; y <= chunkPos.getY() + 1; y++) {
            for (int x = chunkPos.getX() -1; x <= chunkPos.getX() + 1; x++) {
                newChunks[i] = ChunkFile.loadChunk(x, y);
                i++;
            }
        }
        
        loadedChunks = newChunks;
        
    }

    public boolean checkObstacle(Vector2 position) {
        // for (Chunk c : loadedChunks) {
            // Tile[] tiles = c.getTiles();
            // for (Tile tile : tiles) {
                // if (tile.getPosition().equals(position)) {
                    // return tile.getUeberwindbar();
                // }
            // }
        // }

        return false;
    }
}
