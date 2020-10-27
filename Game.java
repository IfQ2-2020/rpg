import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Gamemode implements KeyListener
{
    private World world;
    private JFrame frame;
    
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
        world.loadNextChunks();
        Chunk[] chunks = world.getLoadedChunks();
        for (Chunk c : chunks) {
            if (c == null)
                continue;
            
            Tile[] tiles = c.getTiles();
            for (Tile tile : tiles) {
                Vector2 relative = tile.getPosition().subtract(pos);
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
    
    @Override
    public void setFrame(JFrame pFrame){
        frame = pFrame;
        frame.addKeyListener(this);
    }  
    
    public void keyPressed(KeyEvent e) {
        world.getLocalPlayer().keyPressed(e.getKeyCode());
    }
        
    public void keyReleased(KeyEvent e) {
    }
        
    public void keyTyped(KeyEvent e) {
    }
}
