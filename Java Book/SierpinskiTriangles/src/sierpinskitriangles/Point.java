
package sierpinskitriangles;

public class Point {
    private int x, y;
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
    
    static Point midPoint(Point p1, Point p2) {
        int x, y;
        x = (p1.getX() + p2.getX()) / 2;
        y = (p1.getY() + p2.getY()) / 2;
        return new Point(x,y);
    }
    
}
