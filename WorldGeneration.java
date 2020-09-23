public class WorldGeneration {
    private Tile[][] generatedTiles;
    private Vector2 dimensions;

    private static final int CHUNK_SIZE = 16;

    public WorldGeneration(int width, int height) {
        dimensions = new Vector2(width, height);
        generatedTiles = new Tile[width][height];
    }

    // Generiert eine map aus Fluss Tiles und unbestimmten Tiles, welche später ausgefüllt werden
    private void generateHeightmap(){
        int width = dimensions.getX();
        int height = dimensions.getY();

        for(int i = 0; i < height; ++i) {     // y
            for(int j = 0; j < width; ++j) {  // x
                double x = (double)j/((double)width);
                double y = (double)i/((double)height);

                // Typical Perlin noise
                double n = ImprovedNoise.noise(10 * x, 10 * y, 1);
                // Wood like structure
                n = n - Math.floor(n);

                if(n > 0.3 + 0.4 * distance_squared(i,j)) {
                    // Tile 0 indiziert im moment nichts und 1 fluss
                    generatedTiles[j][i] = Tiles.createTileAt(0, j, i);
                } else {
                    double a = ImprovedNoise.noise(10 * (x), 10 * (y-1/(double)width), 1);
                    double b = ImprovedNoise.noise(10 * (x-1/(double)width), 10 * (y), 1);
                    double c = ImprovedNoise.noise(10 * (x+1/(double)width), 10 * (y), 1);
                    double d = ImprovedNoise.noise(10 * (x), 10 * (y+1/(double)width), 1);
                    a = a - Math.floor(a);
                    b = b - Math.floor(b);
                    c = c - Math.floor(c);
                    d = d - Math.floor(d);

                    if((a > 0.3 + 0.4 * distance_squared(i,j) && y != 0 )||
                            (b > 0.3 + 0.4 * distance_squared(i,j) && x != 0) ||
                            (c > 0.3 + 0.4 * distance_squared(i,j) && x != width-1 )||
                            (d > 0.3 + 0.4 * distance_squared(i,j) && y != height - 1))
                    {
                        generatedTiles[j][i] = Tiles.createTileAt(1, j, i);
                    } else {
                        generatedTiles[j][i] = Tiles.createTileAt(0, j, i);
                    }
                }
            }
        }
    }

    private float distance_squared(int x, int y) {
        float dx = 2 * x / dimensions.getX() - 1;
        float dy = 2 * y / dimensions.getY() - 1;
        //at this point 0 <= dx <= 1 and 0 <= dy <= 1
        return dx*dx + dy*dy;
    }

    // Füllt die restlichen Tiles nach der Flussgeneration
    private void fillRemainingTiles() {

    }

    public Tile[][] getGeneratedTiles() {
        return generatedTiles;
    }

    public Chunk[][] groupToChunks() {
        // Initialize Chunk 2 Dimensional Array
        Chunk[][] ret = new Chunk[dimensions.getX() / CHUNK_SIZE][dimensions.getY() / CHUNK_SIZE];
        for (int x = 0; x < ret.length; x++)
            for (int y = 0; y < ret[x].length; y++)
                ret[x][y] = new Chunk(new Vector2(x * 16, y * 16), CHUNK_SIZE);

        // Jeden chunk mit den generierten Tiles füllen
        for (int i = 0; i < generatedTiles.length; i++) {
            for (int j = 0; j < generatedTiles[i].length; j++) {
                int chunkX = j / CHUNK_SIZE;
                int chunkY = i / CHUNK_SIZE;
                ret[chunkX][chunkY].setTileIndex(i % CHUNK_SIZE + (j % CHUNK_SIZE) * CHUNK_SIZE, generatedTiles[i][j]);
            }
        }

        return ret;
    }

    public Vector2 getDimensions() {
        return dimensions;
    }
}