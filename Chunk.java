public class Chunk{

    private Tile[] tiles;
    private int[] position;// von tile oben links
    private boolean isFirstChunk;
    
    public Chunk(Chunk[] pNextChunks, int[] pPosition, boolean pisFirstChunk){
        //NextCHunks: oben 0 links 1 rechts 2 unten 3
        isFirstChunk = pisFirstChunk;
        tiles = createTiles(pNextChunks, isFirstChunk);
        position = pPosition;
        
    }
    
    private Tile[] createTiles(Chunk[] pNextChunks, boolean isFirst){
        Tile[] ret = new Tile[16*16];
        Chunk[] nextChunks = pNextChunks;
        if(!isFirst){
            for(int y = 0; y < 16; y++){
                for(int x = 0; x < 16; x++){
                    
                    ret[returnTilenumber(x,y)] = new Tile(0);
                    if(nextChunks[0] != null && y == 0){
                       ret[returnTilenumber(x,y)] =  nextChunks[0].tiles[
                                                    returnTilenumber(x,15)];
                    }
                    if(nextChunks[1] != null && x == 0){
                        ret[returnTilenumber(x,y)] =  nextChunks[1].tiles[
                                                    returnTilenumber(0,y)];
                    }
                    if(nextChunks[2] != null && x == 15){
                        ret[returnTilenumber(x,y)] =  nextChunks[2].tiles[
                                                    returnTilenumber(15,y)];
                    }
                    if(nextChunks[3] != null && y == 15){
                        ret[returnTilenumber(x,y)] =  nextChunks[3].tiles[
                                                    returnTilenumber(x,0)];
                    }
                }
            }
        }else{
            for(int y = 0; y < 16; y++){
                for(int x = 0; x < 16; x++){
                    ret[returnTilenumber(x,y)] = new Tile(0);
                    
                    if(x == 0 || x == 15 || y == 0 || y == 15){
                        ret[returnTilenumber(x,y)] = new Tile(1); 
                    }
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