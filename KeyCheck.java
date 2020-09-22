import java.awt.event.*;

// Test Class
public class KeyCheck implements KeyListener {
        public void keyPressed(KeyEvent e) {
            System.out.println("Key Code: " + e.getKeyCode());
        }
        
        public void keyReleased(KeyEvent e) {
            
        }
        
        public void keyTyped(KeyEvent e) {
        }
    }
    //this.addKeyListener(new KeyCheck());