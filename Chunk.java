public class Chunk{

    private Tile[] tiles;
    private int[] position;// von tile oben links
    
    public Chunk(Chunk[] pNextChunks, int[] pPosition){
        //NextCHunks: oben 0 links 1 rechts 2 unten 3
        tiles = createTiles(pNextChunks);
        position = pPosition;
    }
    
    private Tile[] createTiles(Chunk[] pNextChunks){
        Tile[] ret = new Tile[16*16];
        Chunk[] nextChunks = pNextChunks;
        
        for(int y = 0; y < 16; y++){
            for(int x = 0; x < 16; x++){
                
                ret[returnTilenumber(x,y)] = new Tile(0);
                
                if(x == 0){
                    ret[returnTilenumber(x,y)] = new Tile(1); 
                }
            }
        }
        
        return ret;
    }
    
    private int returnTilenumber(int pX, int pY){
        return 16 * pY + pX;
    }
    
    private Tile getTileFromChunk(int pI){
        return tiles[pI];
    }
}