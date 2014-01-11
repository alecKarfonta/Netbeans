package JLabelBorders;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.*;

public class JLabelBorders extends JFrame {
    public JLabelBorders() {
        setLayout(new FlowLayout());
        
        JLabel label1 = new JLabel("If I have seen further than others it is because I stand on the shoulders of giants.");
        JLabel label2 = new JLabel("Truth is the offspring of silence and unbroken meditation.");
        JLabel label3 = new JLabel("We build too many walls and not enough bridges.");
        JLabel label4 = new JLabel("The key to chastity is not to sruggle with ye thoughts directly, but to avert ye thoughts through some employment, through reading or meditating on other things.");
        
        label1.setBorder(new LineBorder(Color.RED, 3));
        label2.setBorder(new LineBorder(Color.BLUE, 3));
        label3.setBorder(new LineBorder(Color.GREEN, 3));
        label4.setBorder(new LineBorder(Color.YELLOW, 3));
        
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JLabelBorders();
        
        frame.setTitle("Newton Quotes");
        frame.setSize(1100, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
