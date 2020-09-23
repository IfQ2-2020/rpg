public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;

    /* Die vom localPlayer geladenen Chunks
    1  2  3
    4 (5) 6 // 5 auf den Spieler zentriert
    7  8  9
     */
    private Chunk[] loadedChunks;
    private int width = 1600, height = 1600;
    private Spieler localPlayer;
    
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[9];
    }

    public Spieler getLocalPlayer() {
        return localPlayer;
    }
    
    public Chunk[] getLoadedChunks() {
        return loadedChunks;
    }

    public void loadNextChunks() {
        Vector2 pos = localPlayer.getPosition();

    }

    public boolean checkObstacle(Vector2 position) {
        for (Chunk c : loadedChunks) {
            Tile[] tiles = c.getTiles();
            for (Tile tile : tiles) {
                if (tile.getPosition().equals(position)) {
                    return tile.getUeberwindbar();
                }
            }
        }

        return false;
    }

    // ?
    /*private void loadFirstChunks(){
        loadedChunks[0] = new Chunk(null,new Vector2(0,0), true,this);
        loadedChunks[1] = new Chunk(new Chunk[]{null,null,null,loadedChunks[0]},
                                    new Vector2(0,16), false,this);
        loadedChunks[2] = new Chunk(new Chunk[]{null,null,loadedChunks[0],null},
                                    new Vector2(-16,0), false,this);
        loadedChunks[3] = new Chunk(new Chunk[]{null,loadedChunks[0],null,null},
                                    new Vector2(16,0), false,this); 
        loadedChunks[4] = new Chunk(new Chunk[]{loadedChunks[0],null,null,null},
                                    new Vector2(0,-16), false,this);                            
    }*/
}
