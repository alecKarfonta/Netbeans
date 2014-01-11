package ImageIconDemo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ImageIconDemo extends JFrame {
    private ImageIcon iiNewton = new ImageIcon("image/newton.jpg");
    private ImageIcon iiEinstein = new ImageIcon("image/einstein.jpg");
    private ImageIcon iiSagan = new ImageIcon("image/sagan.jpg");
    private ImageIcon iiTesla = new ImageIcon("image/tesla.jpg");
    private ImageIcon iiHawking = new ImageIcon("image/hawking.jpg");
    private ImageIcon iiFeynman = new ImageIcon("image/feynman.jpg");
    
    public ImageIconDemo() {
        setLayout(new GridLayout(0, 4, 5, 5));
        
        JLabel jlNewton = new JLabel(iiNewton);
        JLabel jlEinstein = new JLabel(iiEinstein);
        JLabel jlSagan = new JLabel(iiSagan);
        JLabel jlTesla = new JLabel(iiTesla);
        JLabel jlHawking = new JLabel(iiHawking);
        JLabel jlFeynman = new JLabel(iiFeynman);
             
        jlNewton.setBorder(new LineBorder(Color.CYAN, 3));
        jlEinstein.setBorder(new LineBorder(Color.BLUE, 3));
        jlSagan.setBorder(new LineBorder(Color.GREEN, 3));
        jlTesla.setBorder(new LineBorder(Color.ORANGE, 3));
        jlHawking.setBorder(new LineBorder(Color.RED, 3));
        jlFeynman.setBorder(new LineBorder(Color.white, 3));
        
        
        add(jlNewton);
        add(jlEinstein);
        add(jlSagan);
        add(jlTesla);
        add(jlHawking);
        add(jlFeynman);
    }
    
    public static void main(String[] args) {
        JFrame frame = new ImageIconDemo();
        
        frame.setTitle("Hero Icons");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
