
package ThinkingInObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.*;

public class shapePanel extends JPanel {
    Shape[] shape = new Shape[10];
    int numOfShapes = 0;
    public shapePanel(Shape shape)  {
        this.shape[this.numOfShapes] = shape;
        numOfShapes++;
    }
    public void addShape(Shape shape) {
        this.shape[this.numOfShapes] = shape;
        this.numOfShapes++;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;    
        for (int i = 0; i < this.numOfShapes; i++) {
            g2.draw(this.shape[this.numOfShapes]);
        }
        
    }
}