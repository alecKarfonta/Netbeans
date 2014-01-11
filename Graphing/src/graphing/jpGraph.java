
package graphing;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class jpGraph extends JPanel {
    ArrayList<Line> lines;
    ArrayList<Point> points;
    public jpGraph() {
        this(new ArrayList<Line>(), new ArrayList<Point>());
    }
    public jpGraph(ArrayList<Line> lines) {
        this(lines, new ArrayList<Point>());
    }
    public jpGraph(ArrayList<Line> lines, ArrayList<Point> points) {
        this.lines = lines;
        this.points = points;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (lines != null) {
            for (Line line : lines) {
                g.setColor(line.getColor());
                g.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
            }
        }
        if (points != null) {
            for (Point point : points) {
                g.setColor(point.getColor());
                g.drawLine(point.getX(), point.getY(), point.getX(), point.getY());
            }
        }
    }
}
