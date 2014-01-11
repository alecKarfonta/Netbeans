package Newegg;

import com.google.gson.JsonArray;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.net.www.http.HttpClient;

public class NeweggApiFrame extends JFrame implements ActionListener {
    String rootUrl = "http://www.ows.newegg.com/";
    public NeweggApiFrame() {
            setLayout(new GridLayout(10, 0));
            
            JButton jbCategories = new JButton("Stores");
            JButton jbDailyDeals = new JButton("Daily Deals");
            JButton jbShellShocker = new JButton("Shell Shocker");
            jbCategories.addActionListener(this);
            add(jbCategories);
            add(jbDailyDeals);
            add(jbShellShocker);
        
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Command: " + ae.getActionCommand());
        try {
            /*
             * // Stores clicked
             */
            if (ae.getActionCommand().matches("Stores")) {
                
                String url = rootUrl + "Stores.egg/Menus";
                
                System.out.print("API Call: ");
                System.out.println(url);
                
                JsonArray jsonArray = JsonArrayFunctions.getJsonArrayFromAPI(url);

                ArrayList<JButton> buttons = new ArrayList<JButton>();

                JFrame jpCategories = new JFrame();

                jpCategories.setLayout(new GridLayout(10, 0));
                for (int index = 0; index < jsonArray.size(); index++) {
                    buttons.add(new JButton(jsonArray.get(index).getAsJsonObject().get("Title").toString()));
                    buttons.get(index).setActionCommand("Store:" + jsonArray.get(index).getAsJsonObject().get("StoreID").toString());
                    buttons.get(index).addActionListener(this);
                    jpCategories.add(buttons.get(index));
                }  
                
                jpCategories.setSize(1024,600);
                jpCategories.setTitle("Stores");
                jpCategories.setVisible(true);
            }
            
            /*
             * // Store Clicked
             */
            else if (ae.getActionCommand().startsWith("Store:")) {

                String url = rootUrl + "Stores.egg/Categories/" + ae.getActionCommand().substring(6);
                
                System.out.print("API Call: ");
                System.out.println(url);
                
                JsonArray jsonArray = JsonArrayFunctions.getJsonArrayFromAPI(url);

                ArrayList<JButton> buttons = new ArrayList<JButton>();

                JFrame jpCategories = new JFrame();

                jpCategories.setLayout(new GridLayout(10, 0));
                for (int index = 0; index < jsonArray.size(); index++) {
                    buttons.add(new JButton(jsonArray.get(index).getAsJsonObject().get("Description").toString()));
                    buttons.get(index).setActionCommand("Category" 
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("CategoryType").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("StoreID").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("CategoryID").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("NodeId").toString());
                                                        
                    buttons.get(index).addActionListener(this);
                    jpCategories.add(buttons.get(index));
                }  
                JButton exit = new JButton("Exit");
                jpCategories.setSize(1024,600);
                jpCategories.setTitle("Categories");
                jpCategories.setVisible(true);
            }
            
            /*
             * // Category Clicked
             */
            else if (ae.getActionCommand().startsWith("Category")) {
                
                String[] fields = ae.getActionCommand().split(",");
                StringBuilder url = new StringBuilder(rootUrl);
                url.append("Stores.egg/Navigation/");
                for (int index = 2; index < fields.length; index++) {       // add the fields after the categoryType
                    url.append(fields[index]);
                    url.append("/");
                }
                
                boolean isRootCategory = Boolean.parseBoolean(fields[1]);
                
                System.out.print("API Call: ");
                System.out.println(url.toString());
                System.out.print("isRootCategory: ");
                System.out.println(isRootCategory);
                
                JsonArray jsonArray = JsonArrayFunctions.getJsonArrayFromAPI(url.toString());

                ArrayList<JButton> buttons = new ArrayList<JButton>();

                JFrame jpCategories = new JFrame();

                
                jpCategories.setLayout(new GridLayout(10, 0));
                for (int index = 0; index < jsonArray.size(); index++) {
                    buttons.add(new JButton(jsonArray.get(index).getAsJsonObject().get("Description").toString()));
                    buttons.get(index).setActionCommand("Category" 
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("CategoryType").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("StoreID").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("CategoryID").toString()
                                                        + "," + jsonArray.get(index).getAsJsonObject().get("NodeId").toString());
                    buttons.get(index).addActionListener(this);
                    jpCategories.add(buttons.get(index));
                }  
                
                jpCategories.setSize(1024,600);
                jpCategories.setTitle("Sub-Catgories");
                jpCategories.setVisible(true);
            }
            }
        
        catch (UnsupportedEncodingException ex) {
                System.out.println(ex.toString());
            }
        
        DefaultHttpClient httpClient = new DefaultHttpClient();
        /* */
        try {
            HttpPost request = new HttpPost("http://www.ows.newegg.com/Search.egg/Advanced");
            
            StringEntity params =new StringEntity("data = {\n" +
                                                "    \"SubCategoryId\": 147, \n" +
                                                "    \"NValue\": \"\", \n" +
                                                "    \"StoreDepaId\": 1, \n" +
                                                "    \"NodeId\": 7611, \n" +
                                                "    \"BrandId\": -1, \n" +
                                                "    \"PageNumber\": 1, \n" +
                                                "    \"CategoryId\": 17\n" +
                                                "}");
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            
            System.out.println(request.toString());
            System.out.println("\n" + params.getContent());
            //HttpResponse response = httpClient.execute(request);
            /*
            System.out.println(response);
            // handle response here...
            /**/
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        /**/
        System.out.println("--------------------------------------------------------------------------------------");
        
    }
    
    public static void main(String[] args) {
        NeweggApiFrame frame = new NeweggApiFrame();
        frame.setSize(1024,600);
        frame.setTitle("NeweggApiFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// add a button that generates the code for a category