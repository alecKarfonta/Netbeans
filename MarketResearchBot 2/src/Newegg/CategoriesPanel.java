package Newegg;

import com.google.gson.JsonArray;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aj9027
 */
public class CategoriesPanel extends JPanel implements ActionListener {
    protected String urlAppendage = "";
    public CategoriesPanel() {
        this(new JsonArray());
    }
    public CategoriesPanel(JsonArray jsonArray) {
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        setLayout(new GridLayout(jsonArray.size(), 1));
        for (int index = 0; index < jsonArray.size(); index++) {
            buttons.add(new JButton(jsonArray.get(index).getAsJsonObject().get("Title").toString()));
            buttons.get(index).setActionCommand(jsonArray.get(index).getAsJsonObject().get("StoreID").toString());
            buttons.get(index).addActionListener(this);
            add(buttons.get(index));
        }   
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        urlAppendage = ae.getActionCommand();
    }

    public String getUrlAppendage() {
        return this.urlAppendage;
    }
    
}
