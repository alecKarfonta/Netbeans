package JPanelDemo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelDemo extends JPanel {
    public JPanelDemo() {
        setLayout(new FlowLayout());
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
    }
}
