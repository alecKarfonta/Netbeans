package TicTacToe;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToe extends JFrame {
    private ImageIcon iiX = new ImageIcon("image/x.gif");
    private ImageIcon iiO = new ImageIcon("image/o.gif");
    
    public TicTacToe() {
        setLayout(new GridLayout(3, 0, 10, 10));
        
        for (int i = 0; i < 9; i++) {
            int value = (int)(Math.random() * 3);
            System.out.println(value);
            if (value == 0 ) {
                add(new JButton(iiX));
            }
            else if(value == 1) {
                add(new JButton(iiO));
            }
            else if(value == 2) {
                add(new JButton(""));
            }
        }
        
    }
    
    public static void main(String[] args) {
        JFrame board = new TicTacToe();
        
        board.setTitle("Tic Tac Toe");
        board.pack();
        board.setLocationRelativeTo(null);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
    }
}
