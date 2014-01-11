
package sierpinskitriangles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class jpLine extends JPanel {
    ArrayList<Line> lines = new ArrayList<Line>();
    ArrayList<Point> points = new ArrayList<Point>();
    
    public jpLine() {}
    public jpLine(ArrayList<Line> lines) {
        this.lines = lines;
    }
    public jpLine(ArrayList<Line> lines, ArrayList<Point> points) {
        this.lines = lines;
        this.points = points;
    }
    public void addLines(ArrayList<Line> newLines) {
        if (lines != null) {
            for (Line newLine : newLines) {
                this.lines.add(newLine);
            }
        }
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.setColor(Color.BLACK);
            g.drawLine((int)line.getStartX(), (int)line.getStartY(), (int)line.getEndX(), (int)line.getEndY());
        }
        for (Point point : points) {
            g.setColor(Color.BLACK);
            g.drawLine((int)point.getX(), (int)point.getY(), (int)point.getX(), (int)point.getY());
        }
    }
}


