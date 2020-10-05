import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChunkFile
{
    // Dateinamen Spezifikation:
    // X-i-j.rcf // RPG Chunk File
    // Chunk Base Position = welt position / chunk size
    public static Chunk loadChunk(int x, int y){
        FileInputStream in = null;
        
        try {
            in = new FileInputStream("./save/Y-" + y + ".rcf");
            // skip first chunks in file
            in.skip(x * 256);

            // create chunk we want to load
            Chunk c = new Chunk(new Vector2(x, y), 16);
            x *= 16;
            y *= 16;
            
            int r;
            for (int i = 0; i < 16 * 16 && (r = in.read()) != -1; i++) {
                Vector2 pos = new Vector2(x + i % 16, y + i / 16);
                c.setTileIndex(i, new Tile(r, pos));
            }
            
            return c;
        } catch (IOException e) {
            System.out.println("Error loading Chunk: " + e);
            return null;
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    public static void saveChunks(Chunk[] chunks) throws IOException {
        FileOutputStream out = null;
        
        try {
            int y = chunks[0].getPosition().getY();
            out = new FileOutputStream("./save/Y-" + y + ".rcf");
            
            for (Chunk chunk : chunks) {
                Tile[] tiles = chunk.getTiles();
            
                for (Tile t : tiles) {
                    out.write(t.getID());
                }
            }
        } finally {
            if (out != null)
                out.close();
        }
    }
}
