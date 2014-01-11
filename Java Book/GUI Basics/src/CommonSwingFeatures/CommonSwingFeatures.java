
package CommonSwingFeatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class CommonSwingFeatures extends JFrame {
    private Font font = new Font("Serif", Font.PLAIN, 30);
    
    public CommonSwingFeatures() {
        setLayout(new GridLayout(0, 1, 5, 10));
        
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        
        label1.setBackground(Color.white);
        label2.setBackground(Color.white);
        label3.setBackground(Color.white);
        label4.setBackground(Color.white);
        label5.setBackground(Color.white);
        label6.setBackground(Color.white);

        label1.setForeground(Color.green);
        label2.setForeground(Color.CYAN);
        label3.setForeground(Color.GRAY);
        label4.setForeground(Color.MAGENTA);
        label5.setForeground(Color.red);
        label6.setForeground(Color.blue);
        
        label1.setBorder(new LineBorder(Color.yellow, 2));
        label2.setBorder(new LineBorder(Color.yellow, 2));
        label3.setBorder(new LineBorder(Color.yellow, 2));
        label4.setBorder(new LineBorder(Color.yellow, 2));
        label5.setBorder(new LineBorder(Color.yellow, 2));
        label6.setBorder(new LineBorder(Color.yellow, 2));
        
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        
        label1.setText("A celebate clergy is an especially good idea because it tends to supress any hereditary propensity toward fanatiscism.");
        label2.setText("I have studied these things - you have not.");
        label3.setText("The religion of the future will be a cosmic religion. It should transcend personal God and avoid dogma and theology.");
        label4.setText("Ignorance is preferable to error, and he is less remote from the truth who believes nothing than he who believes what is wrong.");
        label5.setText("All national institutions of churches... appear to me no other than human inventions, set up to terrify and enslave mankind, and monopolize power and profit.");
        label6.setText("If religious instruction were not allowed until the child had attained the age of reason, we would be living in a quite different world.");
        
        label1.setToolTipText("Source: Carl Sagan - Contact");
        label2.setToolTipText("Source: Isacc Newton - Response to Halley's remarks on religion");
        label3.setToolTipText("Source: Albert Einstein - Unknown");
        label4.setToolTipText("Thomas Jefferson - Notes on Virginia");
        label5.setToolTipText("Thomas Paine - Age of Reason");
        label6.setToolTipText("Chistopher Hitchens - God is Not Great");
        
        add(label1);
        add(label2);
        add(label4);
        add(label5);
        add(label6);
    }
    
    public static void main(String[] args) {
       JFrame frame = new CommonSwingFeatures();
       frame.setTitle("Quotes on Religion");
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
    }
}
