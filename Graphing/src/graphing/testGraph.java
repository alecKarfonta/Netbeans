package graphing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class testGraph {
    public static void main(String[] args) {
        int width = 1000;
        int height = 800;
        int tickRadius = 5;
        int tickDistance = 10;
        
        ArrayList<Line> lines = new ArrayList<Line>();
        
        Line xAxis = new Line(new Point(0,height/2), new Point (width,height/2));
        Line yAxis = new Line(new Point(width/2, 0), new Point(width/2, height));
        
        lines.add(xAxis);
        lines.add(yAxis);
        
        ArrayList<Line> xTick = new ArrayList<Line>();
        
        // add ticks to y axis
        for ( int y = 0; y < height; y += tickDistance) {
            lines.add(new Line(new Point(width/2 - tickRadius, y), new Point(width/2 + tickRadius, y)));
        }
        
        // add ticks to the x axis
        for (int x = 0; x < width; x += tickDistance) {
            lines.add(new Line(new Point(x, height/2 - tickRadius), new Point(x, height/2 + tickRadius)));
        }
        
        ArrayList<Point> points = new ArrayList<Point>();
        
        points.add(new Point(100, 100));
        
        lines.add(new Line(new Point(50,600), new Point(600,650)));
        
        JPanel graph = new jpGraph(lines, points);        
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        graph.setPreferredSize(new Dimension(width, height));
        frame.add(graph);
        
        frame.setTitle("Test Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setVisible(true);
        
    }
}
