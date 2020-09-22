import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/*
 * Author: Julius K
 * Klasse zum schnelleren laden von Texturen
 * (Damit die Texturen nicht bei jedem laden neu von der Datei aus geladen werden)
 */
public class Textures
{
    private static HashMap<Integer, BufferedImage> cachedTextures =
        new HashMap<Integer, BufferedImage>();
    
    public static BufferedImage get(int id) {
        BufferedImage ret = cachedTextures.get(id);
        if (ret != null)
            return ret;
        
        try {
            ret = ImageIO.read(new File("./textures/" + id + ".png"));
            cachedTextures.put(id, ret);
            return ret;
        } catch (IOException _) {
            return null;
        }
    }
    
    /*
     * Debug Methode um die Cache zu leeren
     */
    public static void clear() {
        cachedTextures.clear();
    }
}
