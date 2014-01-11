
package graphing;

import java.awt.Color;

public class Line {
    private Point[] points;
    private Color color;
    public Line() {}
    public Line(Point start, Point end) {
        this(new Point[]{start, end});
    }
    public Line(Point[] points) {
        this(points, Color.BLACK);        
    }
    public Line(Point[] points, Color color) {
        //System.out.println("Line constructed \t Points: " + points.length);
        this.points = new Point[points.length];
        for (int index = 0; index < points.length; index++) {
           this.points[index] = points[index];
        }
        this.color = color;
    }
    public double getSlope() {
        double slope;
        // m = (y2 - y1) / (x2 - x1)
        try {
            slope = (points[1].getY() - points[0].getY()) / (points[1].getX() - points[0].getX());
        
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
            slope = 0;
        }
        return slope;
    }
    public int getLength() {
        int length;
        
        // distance formula: d = sqrt( (y2-y1)^2 + (x2-x1)^2 ) 
        length = (int) Math.sqrt( Math.pow((double)(points[1].getY() - points[0].getY()),2) 
                + Math.pow((double)(points[1].getX() - points[0].getX()),2) );
        
        return length;
    }
    
    @Override
    public String toString() {
        return "(" + points[0].getX() + "," + points[0].getY() + ") "
                + "- (" + points[points.length-1].getX() + "," + points[points.length-1].getY() + ")"; 
    }
    
    public int getStartX() {
        return points[0].getX();
    }
    
    public int getEndX() {
        return points[points.length-1].getX();
    }
    public int getStartY() {
        return points[0].getY();
    }
    
    public int getEndY() {
        return points[points.length-1].getY();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
