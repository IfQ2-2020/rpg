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
    
    public Game(GameContainer pContainer, World pWorld)
    {
        super(pContainer);
        world = pWorld;
        this.addKeyListener(new KeyCheck());
    }
   
    private static final int relDrawPos = 768/2 - 32;
    
    @Override
    public void _update(Graphics g) {
        //System.out.print("update in game");
        // TODO: draw tiles around player
        Spieler p = world.getLocalPlayer();
        Vector2 pos = p.getPosition();
        
        Chunk[] chunks = world.getLoadedChunks();
        for (Chunk c : chunks) {
            Tile[] tiles = c.getTiles();
            for (Tile tile : tiles) {
                Vector2 relative = pos.subtract(tile.getPosition());
                relative = relative.add(new Vector2(world.getDimensions().getX()/2,
                                        world.getDimensions().getY()/2));
                //System.out.println(relative.getX()+" , " + relative.getY());
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
