package BorderLayoutDemo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutDemo extends JFrame {
    public BorderLayoutDemo() {
        setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        
        panel1.add(new JButton("1"));
        panel1.add(new JButton("2"));
        panel1.add(new JButton("3"));
        
        panel2.add(new JButton("4"));
        panel2.add(new JButton("5"));
        panel2.add(new JButton("6"));
        
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        }
    
    public static void main(String[] args) {
        JFrame frame = new BorderLayoutDemo();
        
        frame.setTitle("BorderLayoutDemo");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
