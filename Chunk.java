public class Chunk{

    private int ID;
=======
    private int ID;// Starts at 1
>>>>>>> c53a284cb585314712af23c1dbab4921ca916c31
    private Tile[] tiles;
    
<<<<<<< HEAD
    public Chunk(int pID, Chunk[] pNextChunks){
=======
    public Chunk(int pID, Chunk[] pNextChunks){// oben links 0 oben mitte 1 
        //oben rechts 2 mitte links 3 mitte rechts 4,..., unten rechts 7
>>>>>>> c53a284cb585314712af23c1dbab4921ca916c31
        tiles = createTiles();
    }
    
    private Tile[] createTiles(){
        Tile[] ret = new Tile[16*16];
        
        for(int y = 0; y < 16; y++){
            for(int x = 0; x < 16; x++){
                ret[returnTilenumber(x,y)] = new Tile(0); 
            }
        }
        
        return ret;
    }
    
    private int returnTilenumber(int pX, int pY){
        return 16 * pY + pX;
    }
}