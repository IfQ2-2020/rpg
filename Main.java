import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame("abc");
        
        f.add(new Gamemode());
        
//        f.setResizable(false);
        
        f.pack();
        
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setSize(768, 768);
        f.setVisible(true);
    }
}
