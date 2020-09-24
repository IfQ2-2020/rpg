public class Chunk {
    private Tile[] tiles;
    private Vector2 position;// von tile unten links
    public Chunk(Vector2 pPosition, int chunkSize){
        //NextCHunks: oben 0 links 1 rechts 2 unten 3
        position = pPosition;
        tiles = new Tile[chunkSize * chunkSize];
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