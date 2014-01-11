package shapes;

/**

	Author: David Smiley

*/

import java.awt.*;
import java.awt.geom.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Shapes
{

/**
    @param args
    @throws IOException
*/

   public static void main(String[] args) throws IOException
   {

      JFrame frame = new JFrame();
      frame.setSize(800, 600);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      int shapeChoice = 0; 
      String output = "";
      
      while (shapeChoice != 5 && !frame.isVisible())
      {
         shapeChoice = Integer.parseInt(JOptionPane.showInputDialog("Select a shape \n"
              + " 1 - Square \n 2 - Rectangle \n 3 - Triangle \n 4 - Circle \n 5 - Exit"));
         if (shapeChoice > 6 || shapeChoice < 0)
         {
            JOptionPane.showMessageDialog(null, "Invalid Choice"); 
            break;
         }
         
         float len;
         float wid;
         float rad;
         float side;
         float side2;
         float side3;
         output = "You created a "; // output string to hold data on the shape
         Square s = null; 
         switch (shapeChoice)
         {
            case 1:
            {
               output += "Square \n";
               side = Float.parseFloat(JOptionPane.showInputDialog("Side Length:"));
               
               if (side > 30 || side < 0) { // Size constraint
                   JOptionPane.showMessageDialog(null, "Can't fit in window.");
                   break;
               }
                   
               s = new Square(side);
               output += "Side: " + side + "cm\n";
               output += "Circumfrence: " + s.getCircum() + "cm\n";
               Shape square = new Rectangle2D.Float(10, 20, side * 10, side * 10);
               shapePanel panel = new shapePanel(square, output);
               frame.add(panel);
               break;
            }
            case 2:
            {
               output += "Rectangle \n";
               len = Float.parseFloat(JOptionPane.showInputDialog("Length:"));
               wid = Float.parseFloat(JOptionPane.showInputDialog("Width:"));
               
               if (len > 30 || len < 0 || wid > 30 || wid < 0) { // Size constraint
                   JOptionPane.showMessageDialog(null, "Can't fit in window.");
                   break;
               }
               
               s = new Rectangle(len, wid);
               output += "Length: " + len + "cm\n";
               output += "Width: " + wid + "cm\n";
               output += "Circumfrence: " + s.getCircum() + "cm\n";
               Shape rect = new Rectangle2D.Float(10, 20, wid * 10, len * 10 );
               shapePanel panel = new shapePanel(rect, output);
               frame.add(panel);
               break;
            }
            case 3:
            {
               output += "Triangle \n";
               side = Float.parseFloat(JOptionPane.showInputDialog("Side1:"));
               side2 = Float.parseFloat(JOptionPane.showInputDialog("Side2:"));
               side3 = Float.parseFloat(JOptionPane.showInputDialog("Side3:"));
               if (side > 30 || side < 0 || side2 > 30 || side2 < 0 || side3 > 30 || side3 < 0) { // Size constraint
                   JOptionPane.showMessageDialog(null, "Can't fit in window.");
                   break;
               }
               s = new Triangle(side, side2, side3); // Must have all three sides
               output += "Side1: " + side + "cm\n"   
                            + "Side2: " + side2 + "cm\n"
                            + "Side3: " + side3 + "cm\n";;
               output += "Circumfrence: " + s.getCircum() + "cm\n";
               JOptionPane.showMessageDialog(frame, "Need trig.");
               break;
            }
            case 4:
            {
               output += "Circle \n";
               int response = Integer.parseInt(JOptionPane.showInputDialog("Which do you have?"
                       + "\n 1 - Radius \n 2 - Diameter"));
               if (response == 1 ) {
                   rad = Float.parseFloat(JOptionPane.showInputDialog("Radius:"));
               }
               else if(response == 2) {
                   rad = (float).5 * Float.parseFloat(JOptionPane.showInputDialog("Diameter:"));
               }
               else {
                   JOptionPane.showMessageDialog(null, "Invalid choice.");
                   break;
               }
               if (rad > 15 || rad < 0) { // Size constraint
                   JOptionPane.showMessageDialog(null, "Can't fit in window.");
                   break;
               }
               s = new Circle(rad);
               output += "Radius: " + rad + "cm\n";
               
               output += "Circumfrence: " + s.getCircum() + "cm\n";
               Shape rect = new Ellipse2D.Float(10, 20, rad * 2 * 10, rad * 2 * 10 );
               shapePanel panel = new shapePanel(rect, output);
               frame.add(panel);
               break;
            }
            case 5:
            {
               return;
            } 
         }
         if (s != null) {
              frame.setVisible(true);
          }         
      }
  }
}

