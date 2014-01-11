package GridLayoutDemo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo() {
        setLayout(new GridLayout(2, 3));
        
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        
        panel1.add(new JButton("1"));
        panel2.add(new JButton("2"));
        
        
    }
    
}
