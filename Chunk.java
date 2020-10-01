public class Chunk {
    private Tile[] tiles;
    private Vector2 position;// von tile oben links
    public Chunk(Vector2 pPosition, int chunkSize){
        //NextCHunks: oben 0 links 1 rechts 2 unten 3
        position = pPosition;
        tiles = new Tile[chunkSize * chunkSize];
    }

    public Vector2 getPosition() {
        return position;
    }
    
    public void setTileIndex(int index, Tile tile) {
        tiles[index] = tile;
    }

    private int getTileIndex(int pX, int pY) {
        return 16 * pY + pX;
    }
    
    private Tile getTileFromIndex(int pI){
        return tiles[pI];
    }

    public Tile[] getTiles() {
        return tiles;
    }
}