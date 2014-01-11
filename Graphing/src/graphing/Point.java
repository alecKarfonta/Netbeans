
package graphing;

import java.awt.Color;

public class Point {
    private int x, y;
    private Color color;
    public Point() {
        this(0,0);
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return ("(" + this.x + " , " + this.y + ")");
    }

    public Color getColor() {
        return color;
    }
    
}
