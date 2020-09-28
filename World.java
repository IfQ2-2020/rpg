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
    private Vector2 dimensions = new Vector2(1600,1600);
    public Spieler localPlayer;
    
    WorldGeneration test;
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[9];
        localPlayer = new Spieler("OK",1,0,0,0,1,this);
        //Vorest
        test = new WorldGeneration(1600,1600,2);
        test.generateHeightmap();
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
        
        //vorerst
        double _x = pos.getX()/test.getChunkSize();
        double _y = pos.getY()/test.getChunkSize();
        int x = (int)Math.floor(_x);
        int y = (int)Math.floor(_y);        
        //System.out.println(x);
        x += test.getDimensions().getX()* 0.5 / test.getChunkSize();
        y += test.getDimensions().getY()* 0.5 / test.getChunkSize();
        
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
