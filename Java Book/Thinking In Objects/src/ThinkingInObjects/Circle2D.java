
package ThinkingInObjects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author aj9027
 */
public class Circle2D {
    private double x, y = 0.0;
    private double radius = 1.0;
    private Shape circle;
    private boolean isFilled;
    private Color color;;
    
    
    public Circle2D() {
        makeCircle();
    }
    public Circle2D(double radius) {
        makeCircle();    
    }
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        makeCircle();
    }
    public Circle2D(double x, double y, double radius, boolean isFilled, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isFilled = true;
        this.color = color;
        makeCircle();
    }
    private void makeCircle() {
        circle = new Ellipse2D.Double(x, y, radius, radius);
    }

    public Shape getCircle() {
        return circle;
    }
    
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}
