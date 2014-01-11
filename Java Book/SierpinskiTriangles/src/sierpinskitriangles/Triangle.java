package sierpinskitriangles;

import java.util.ArrayList;

public class Triangle {
    private Point[] points;
    
    public Triangle() {
        points = new Point[3];
    }
    
    public Triangle(Point p1, Point p2, Point p3) {
        this.points = new Point[3];
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
    }
    
    public Triangle(Point[] points) {
        this.points = points;
    }
    
    public ArrayList<Triangle> seed() {
        
        // create three new triangles by connecting the midpoints between the original triangle
        ArrayList<Triangle>  triangles = new ArrayList<Triangle>();
        triangles.add(new Triangle(this.points[0] , Point.midPoint(this.points[0], this.points[2])
                , Point.midPoint(this.points[0], this.points[1])));
        
        triangles.add(new Triangle(Point.midPoint(this.points[0], this.points[2])
                , Point.midPoint(this.points[1], this.points[2])
                , this.points[2]));
        /**/
        triangles.add(new Triangle(Point.midPoint(this.points[0], this.points[1])
                , Point.midPoint(this.points[1], this.points[2])
                , this.points[1]));
        /**/
        return triangles;
    }
    
    public ArrayList<Line> getLines() {
        ArrayList<Line> lines = new ArrayList<Line>();
        
        lines.add(new Line(this.points[0], this.points[1]));
        lines.add(new Line(this.points[1], this.points[2]));
        lines.add(new Line(this.points[0], this.points[2]));
        
        return lines;
    }
    
    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        
        points.add(this.points[0]);
        points.add(this.points[1]);
        points.add(this.points[2]);
        
        return points;
    }
    
    @Override
    public String toString() {
        return "Point 1: (" + this.points[0].getX() + " , " + this.points[0].getY() + ")"
                + "Point 2: (" + this.points[1].getX() + " , " + this.points[1].getY() + ")"
                + "Point 3: (" + this.points[2].getX() + " , " + this.points[2].getY() + ")";
    }
}
