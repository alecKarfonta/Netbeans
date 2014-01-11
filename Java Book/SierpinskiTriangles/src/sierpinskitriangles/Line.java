
package sierpinskitriangles;

public class Line {
    private Point[] points;
    public Line() {}
    public Line(Point startPoint, Point endPoint) {
        this(new Point[]{startPoint,endPoint});
    }
    public Line(Point[] points) {
        //System.out.println("Line constructed \t Points: " + points.length);
        this.points = new Point[points.length];
        for (int index = 0; index < points.length; index++) {
           this.points[index] = points[index];
        }
        
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
    
    public double getStartX() {
        return points[0].getX();
    }
    
    public double getEndX() {
        return points[points.length-1].getX();
    }
    public double getStartY() {
        return points[0].getY();
    }
    
    public double getEndY() {
        return points[points.length-1].getY();
    }
    
}
