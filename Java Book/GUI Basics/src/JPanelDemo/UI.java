package JPanelDemo;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JFrame {
    
    public UI() {
        setLayout(new FlowLayout());
        JPanel panel1 = new JPanelDemo();
        JPanel panel2 = new JPanelDemo();
        add(panel1);
        add(panel2);
    }
        
        
    public static void main(String[] args) {
        JFrame frame = new UI();
       frame.setTitle("JPanelDemo");
       frame.setSize(400, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
    }
}
