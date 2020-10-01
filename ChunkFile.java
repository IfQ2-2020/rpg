import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChunkFile
{
    // Dateinamen Spezifikation:
    // X-i-j.rcf // RPG Chunk File
    // Chunk Base Position = welt position / chunk size
    public static Chunk loadChunk(int i, int j) throws IOException {
        FileInputStream in = null;
        
        try {
            in = new FileInputStream("./save/X-" + i + "-" + j + ".rcf");

            Chunk c = new Chunk(new Vector2(i, j), 16);
            int r;
            for (int x = 0; x < 16 * 16 && (r = in.read()) != -1; x++) {
                Vector2 pos = new Vector2(i + x % 16, j + x / 16);
                c.setTileIndex(x, new Tile(r, pos));
            }
            
            return c;
        } finally {
            if (in != null)
                in.close();
        }
    }
    
    public static void saveChunk(Chunk chunk) throws IOException {
        FileOutputStream out = null;
        
        try {
            Vector2 pos = chunk.getPosition();
            out = new FileOutputStream("./save/X-" + pos.getX() + "-" + pos.getY() + ".rcf");
            Tile[] tiles = chunk.getTiles();
            
            for (Tile t : tiles) {
                out.write(t.getID());
            }
        } finally {
            if (out != null)
                out.close();
        }
    }
}
