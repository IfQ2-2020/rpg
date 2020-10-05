import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Gamemode extends JPanel implements ActionListener
{
    private static final int FRAME_DELAY = 16;
    private Timer timer;
    private GameContainer container;
       
    public Gamemode(GameContainer pContainer)
    {
        container = pContainer;
        init();
    }

    private void init() {
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        timer = new Timer(FRAME_DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        _update(g);

        Toolkit.getDefaultToolkit().sync();
    }
    
    protected void _update(Graphics g) {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public int getTimerDelay() {
        return timer.getDelay();
    }
    
    public void setFrame(JFrame x){
    
    }
}
