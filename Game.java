import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Game extends Gamemode implements KeyListener
{
    private World world;
    
    public Game(GameContainer pContainer, World pWorld)
    {
        super(pContainer);
        world = pWorld;
        this.setFocusable(true);
        this.addKeyListener(this);
    }
   
    private static final int relDrawPos = 768/2 - 32;
    
    @Override
    public void _update(Graphics g) {
        Spieler p = world.getLocalPlayer();
        Vector2 pos = p.getPosition();
      
        //System.out.print("update in game");
        // TODO: draw tiles around player
        
        Chunk[] chunks = world.getLoadedChunks();
        for (Chunk c : chunks) {
            Tile[] tiles = c.getTiles();
            for (Tile tile : tiles) {
                Vector2 relative = pos.subtract(tile.getPosition());
                relative = relative.add(new Vector2(world.getDimensions().getX()/2,
                                        world.getDimensions().getY()/2));
                //System.out.println(relative.getX()+" , " + relative.getY());
                g.drawImage(tile.getTexture(),
                    relative.getX()*32 + relDrawPos,
                    relative.getY()*32 + relDrawPos,
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
    
    public void keyPressed(KeyEvent e) {
            System.out.println("Key Code: " + e.getKeyCode());
            world.getLocalPlayer().keyPressed(e.getKeyCode());
        }
        
    public void keyReleased(KeyEvent e) {
            
    }
        
    public void keyTyped(KeyEvent e) {
    }
}
