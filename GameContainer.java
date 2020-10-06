import javax.swing.JFrame;

public class GameContainer
{
    private Gamemode mode;
    private JFrame frame;
    
    public GameContainer() {
        init();
    }
    
    private void init() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(768, 768);
        frame.setVisible(true);
    }
    
    public void changeMode(Gamemode newMode) {
        if (mode != null) {
            frame.remove(mode);
        }
        
        mode = newMode;
        frame.add(newMode);
        frame.pack();
        frame.setSize(768, 768);
        if(mode.getClass() == Game.class)
            mode.setFrame(frame);
    }
}
