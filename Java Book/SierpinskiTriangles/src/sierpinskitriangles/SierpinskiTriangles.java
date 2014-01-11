package sierpinskitriangles;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SierpinskiTriangles {
    
    // chaos mode
    /**
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        int frameWidth = 1024, frameHeight = 768;
        frame.setTitle("Sierpinski Triangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        ArrayList<Point> points = new ArrayList<Point>();
        
        Triangle baseTriangle = new Triangle( new Point(0, frameHeight)
                , new Point(frameWidth, frameHeight)
                , new Point(frameWidth/2, 0));
        triangles.add(baseTriangle);
    
        for (int index = 0; index < 9; index++) {
            addLayer(triangles);
        }
        
        for (Triangle triangle : triangles) {
            for (Point point : points.add(triangle.getPoints());
        }
        
        
        JPanel linePanel = new jpLine(new ArrayList<Line>(), );
        linePanel.setSize(new Dimension(1024, 768));
        frame.add(linePanel);
        frame.setVisible(true);
    
    
    }
    /**/
    
    
    
    
    
    
    
    
    // line mode
    /**/
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        int frameWidth = 1600, frameHeight = 900;
        frame.setTitle("Sierpinski Triangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        ArrayList<Line> allTriangleLines = new ArrayList<Line>();
        
        Triangle baseTriangle = new Triangle( new Point(0, frameHeight)
                , new Point(frameWidth, frameHeight)
                , new Point(frameWidth/2, 0));
        triangles.add(baseTriangle);

        for (int index = 0; index < 9; index++) {
            addLayer(triangles);
        }
        
        for(Triangle triangle : triangles) {
            for (Line line : triangle.getLines()) {
                allTriangleLines.add(line);
            }
        }
        System.out.println("Number of triangles: " + triangles.size());
        
        JPanel linePanel = new jpLine(allTriangleLines);
        linePanel.setSize(new Dimension(1024, 768));
        frame.add(linePanel);
        frame.setVisible(true);
    }
    
    
    /**/
        
   static public void addLayer(ArrayList<Triangle> triangles) {
        ArrayList<Triangle> newTriangles = new ArrayList<Triangle>();
        for (Triangle triangle : triangles) {
            for (Triangle spawnTriangle : triangle.seed()) {
                newTriangles.add(spawnTriangle);
            }
        }
        for (Triangle triangle : newTriangles) {
            triangles.add(triangle);
        }
    }
}
