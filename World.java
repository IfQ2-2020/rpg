public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;

    /* Die vom localPlayer geladenen Chunks
    0  1  2
    3 (4) 5 // 4 auf den Spieler zentriert
    6  7  8
     */
    private Chunk[] loadedChunks;
    private int width = 1600, height = 1600;
    private Spieler localPlayer;
    
    WorldGeneration test;
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[9];
        localPlayer = new Spieler("OK",1,0,0,0,0,this);
        //Vorest
        test = new WorldGeneration(1600,1600,2);
        test.generateHeightmap();
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
        
        //vorerst
        int x = (int)Math.floor(test.getDimensions().getX() / (pos.getX() * test.getChunkSize()));
        int y = (int)Math.floor(test.getDimensions().getY() / (pos.getY() * test.getChunkSize()));
        Chunk[][] a = test.groupToChunks();
        for(int i = 0; i < loadedChunks.length;i++){
            switch(i){
                case 0: loadedChunks[i] = a[x-1][y-1]; 
                        break;
                case 1: loadedChunks[i] = a[x][y-1]; 
                        break;
                case 2: loadedChunks[i] = a[x+1][y-1]; 
                        break;
                case 3: loadedChunks[i] = a[x-1][y]; 
                        break;
                case 4: loadedChunks[i] = a[x][y]; 
                        break;
                case 5: loadedChunks[i] = a[x+1][y]; 
                        break;
                case 6: loadedChunks[i] = a[x-1][y+1]; 
                        break;
                case 7: loadedChunks[i] = a[x][y+1]; 
                        break;
                case 8: loadedChunks[i] = a[x+1][y+1]; 
                        break;              
            };
        }                
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
}
