package CheckerBoard;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CheckerBoard extends JFrame {
    private JButton[][] buttonArray = new JButton[8][8];                                // 2d array to hold buttons
    public CheckerBoard() {
        setLayout(new GridLayout(0, 8, 0, 0));                                          // 8x8 grid layout
       
        for (int row = 0; row < buttonArray.length; row++) {
            for (int col = 0; col < buttonArray[row].length; col++) {
                buttonArray[row][col] = new JButton();
                if (row % 2 == 0 || row == 0) {                                         // if row is even or first row
                    if (col % 2 == 0) {                                                 // if col is even
                        buttonArray[row][col].setBackground(Color.black);               // set background black
                    }
                    else {
                        buttonArray[row][col].setBackground(Color.red);                 // else set background white
                    }
                }
                
                if (row % 2 != 0) {                                                     // if row is odd
                    if (col % 2 != 0) {                                                 // if col is odd
                        buttonArray[row][col].setBackground(Color.black);               // set background color black
                    }
                    else {
                        buttonArray[row][col].setBackground(Color.red);                 // else set background color white
                    }
                }
                ((JButton)buttonArray[row][col]).setOpaque(true);                       // Set all to opaque
                 
                add(buttonArray[row][col]);                                             // add button to frame
            }
        }
        
    }
    
    
    
    public static void main(String[] args) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        JFrame board = new CheckerBoard();
        board.setBackground(Color.white);
        board.setTitle("Checkers!");
        board.setSize(800,600);
        board.setLocationRelativeTo(null);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        board.setVisible(true);
    }
}
