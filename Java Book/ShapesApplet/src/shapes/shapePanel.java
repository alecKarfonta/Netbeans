
package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.*;

public class shapePanel extends JPanel {
    Shape shape = null;
    String description = "";
    public shapePanel(Shape shape, String description)  {
        this.shape = shape;
        this.description = description;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;    
        g2.draw(this.shape);
        g2.drawString(description, 5, 15);
    }
}