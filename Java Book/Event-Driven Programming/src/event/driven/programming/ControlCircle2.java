package event.driven.programming;

import event.driven.programming.ControlCircle2.CirclePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlCircle2 extends JFrame {
    private JButton jbEnlarge = new JButton("Enlarge");
    private JButton jbShrink  = new JButton("Shrink");
    private CirclePanel circlePanel = new CirclePanel();
    
    protected int startingRadius = 5;
    
    public ControlCircle2() {
        JPanel panel = new JPanel();
        panel.add(jbEnlarge);
        panel.add(jbShrink);
        
        this.add(circlePanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);
        
        jbEnlarge.addActionListener(new EnlargeListener());
        jbShrink.addActionListener(new ShrinkListener());
    }
    
    public static void main(String[] args) {
        JFrame frame = new ControlCircle2();
        frame.setTitle("Circle");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    class EnlargeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            circlePanel.enlarge();
            System.out.println(ae.getActionCommand());
        }
        
    }
    
    class ShrinkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            circlePanel.shrink();
            System.out.println(ae.getActionCommand());
        }
        
    }
    
    class CirclePanel extends JPanel {
        private int radius = startingRadius;
        
        public void enlarge() {
            radius++;
            repaint();
        }
        
        public void shrink() {
            radius--;
            repaint();
        }
        
        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
                    2 * radius, 2 * radius);
            repaint();
        }
        
        public Dimension getPrefferedSize() {
            return new Dimension(200,200);
        }
    }
   
}



