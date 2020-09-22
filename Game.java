import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Game extends Gamemode
{
    private World world;
    
    public Game()
    {
        super();
        this.addKeyListener(new KeyCheck());
    }
   
    private static final int relDrawPos = 768/2 - 32;
    
    @Override
    public void _update(Graphics g) {
        // TODO: draw tiles around player
        Spieler p = world.getLocalPlayer();
        Vector2 pos = p.getPosition();
        
        Chunk[] chunks = world.getLoadedChunks();
        for (Chunk c : chunks) {
            Tile[] tiles = c.getTiles();
            for (Tile tile : tiles) {
                Vector2 relative = pos.subtract(tile.getPosition());
                g.drawImage(tile.getTexture(),
                    relative.getX() + relDrawPos,
                    relative.getY() + relDrawPos,
                    32, 32, null);
            }
        }
        
        // TODO: Draw player     
        g.drawImage(p.getTexture(), relDrawPos, relDrawPos, 32, 32, null);
        
        // TODO: Draw NPCs
        
        // TODO: Draw HUD

        g.setColor(Color.BLACK);
        g.drawString("FPS: " + 1000/this.getTimerDelay(), 5, 10);
    }
}
