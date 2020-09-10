public class Chunk{

    private Tile[] tiles;
    private int[] position;// von tile oben links
    
    public Chunk(Chunk[] pNextChunks, int[] pPosition){
        //NextCHunks: oben 0 links 1 rechts 2 unten 3
        tiles = createTiles();
    }
    
    private Tile[] createTiles(){
        Tile[] ret = new Tile[16*16];
        
        for(int y = 0; y < 16; y++){
            for(int x = 0; x < 16; x++){
                if(y == 0 || x == 0 || y == 15 || x == 15){
                    ret[returnTilenumber(x,y)] = new Tile(1); 
                }else {
                    ret[returnTilenumber(x,y)] = new Tile(0);
                }
            }
        }
        
        return ret;
    }
    
    private int returnTilenumber(int pX, int pY){
        return 16 * pY + pX;
    }
}