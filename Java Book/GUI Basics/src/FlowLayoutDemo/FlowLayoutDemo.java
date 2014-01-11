package FlowLayoutDemo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutDemo extends JFrame {
    public FlowLayoutDemo() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        
        panel1.add(new JButton("1"));
        panel1.add(new JButton("2"));
        panel1.add(new JButton("3"));
        
        panel2.add(new JButton("4"));
        panel2.add(new JButton("5"));
        panel2.add(new JButton("6"));
        
        add(panel1);
        add(panel2);
    }
    
    public static void main(String[] args) {
        JFrame frame = new FlowLayoutDemo();
        
        frame.setTitle("FlowLayoutDemo");
        frame.setSize(600, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
