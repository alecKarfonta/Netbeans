package TriangleClass;

import java.awt.Color;
import java.util.Date;

public class GeometricObject {
    private Date dateCreated;
    private Color color;
    private boolean filled;
    public GeometricObject() {
        dateCreated = new Date();
    }
    public GeometricObject(Color color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    @Override
    public String toString() {
        return "Created on: " + dateCreated + "\nColor: " + color + "\nFilled: " + (filled ? "Yes" : "No");
    }
    
    public Color getColor() {
        return color;
    }
    public boolean isFilled() {
        return filled;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }    
}
