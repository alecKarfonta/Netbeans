/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;

/**
 *
 * @author Server
 */
import javax.swing.JButton;
import javax.swing.JPanel;

public class ShapesApplet extends JApplet {
    //Called when this applet is loaded into the browser.
   StringBuffer buffer;
   int shapeChoice = 0;
    public void init() {
        JPanel panel = new JPanel();
        
        JButton b1 = new JButton("Disable middle button");
        JButton b2 = new JButton("Middle button");
        JButton b3 = new JButton("Enable middle button");
       
       // b3.setMnemonic(KeyEvent.VK_E);
       // b3.setActionCommand("enable");

        //Listen for actions on buttons 1 and 3.
        //b1.addActionListener(this);
        //b3.addActionListener(this);

        b1.setToolTipText("Click this button to disable "
                        + "the middle button.");
        b2.setToolTipText("This middle button does nothing "
                        + "when you click it.");
        b3.setToolTipText("Click this button to enable the "
                        + "middle button.");
    Component add = add(panel);
       
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        addItem("stopping... ");
    }

    @Override
    public void destroy() {
        addItem("preparing for unloading...");
    }

    private void addItem(String newWord) {
        System.out.println(newWord);
    }

    @Override
    public void paint(Graphics g) {
	//Draw a Rectangle around the applet's display area.
        g.drawRect(0, 0, 
		   getWidth() - 1,
		   getHeight() - 1);
    }
}