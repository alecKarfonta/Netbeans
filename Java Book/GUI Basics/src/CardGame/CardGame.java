package CardGame;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardGame extends JFrame{
    
    public CardGame() {
        setLayout(new FlowLayout());
        
        StringBuilder imagePath1 = new StringBuilder("image/card/");
        StringBuilder imagePath2 = new StringBuilder("image/card/");
        StringBuilder imagePath3 = new StringBuilder("image/card/");
        
        int cardNumber1 = 1 + (int)(Math.random() * 52);
        int cardNumber2 = 1 + (int)(Math.random() * 52);
        int cardNumber3 = 1 + (int)(Math.random() * 52);
        
        while (cardNumber2 == cardNumber1) {
            cardNumber2 = 1 + (int)(Math.random() * 52);
        }
        
        while (cardNumber3 == cardNumber2 || cardNumber3 == cardNumber2) {
            cardNumber3 = 1 + (int)(Math.random() * 52);
        }
        
        imagePath1.append(cardNumber1);
        imagePath1.append(".png");
        
        imagePath2.append(cardNumber2);
        imagePath2.append(".png");
        
        imagePath3.append(cardNumber3);
        imagePath3.append(".png");
        
        ImageIcon iiCard1 = new ImageIcon(imagePath1.toString());
        ImageIcon iiCard2 = new ImageIcon(imagePath2.toString());
        ImageIcon iiCard3 = new ImageIcon(imagePath3.toString());
        
        add(new JLabel(iiCard1));
        add(new JLabel(iiCard2));
        add(new JLabel(iiCard3));
    }
    
    public static void main(String[] args) {
        JFrame frame = new CardGame();
        frame.setTitle("Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
}
