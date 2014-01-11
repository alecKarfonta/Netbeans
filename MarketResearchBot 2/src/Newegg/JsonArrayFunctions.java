package Newegg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonArrayFunctions {
    
       public static JsonObject getJsonObjectFromAPI(String url) throws UnsupportedEncodingException  {
           
           JsonParser parser = new JsonParser();
           JsonObject jsonObject = new JsonObject();
            try { 
                // get the string of json from the server
                String jsonString = getJsonStringFromApi(url);
                                
                // parse the json object from the string
                Object responseObject = parser.parse(jsonString);
                jsonObject = (JsonObject)responseObject;

                } 
            catch(Exception ex) {
                System.out.println("Exception! " + ex.getMessage());
            }
            return jsonObject;
        }
       
       
       public static JsonArray getJsonArrayFromAPI(String url) throws UnsupportedEncodingException  {
           
           JsonParser parser = new JsonParser();
           JsonArray jsonArray = new JsonArray();
            try { 
                // get the string of json from the server
                String jsonString = getJsonStringFromApi(url);
                                
                // parse the json object from the string
                Object responseObject = parser.parse(jsonString);
                jsonArray = (JsonArray)responseObject;

                } 
            catch(Exception ex) {
                System.out.println("Exception! " + ex.getMessage());
            }
            return jsonArray;
        }
       
    
        public static String getJsonStringFromApi(String url) throws IOException {
            try {                
                // create the http connection to the ebay api
                String urlCharset = "UTF-8";
                URLConnection connection = new URL(url).openConnection();
                connection.setRequestProperty("Accept-Charset", urlCharset);
                InputStream response = connection.getInputStream();

                // read each line of the Json response into a string
                BufferedReader rd = new BufferedReader(new InputStreamReader(response));  
                String line;
                StringBuilder sbResponse; 
                sbResponse = new StringBuilder();
                while((line = rd.readLine()) != null) {
                  sbResponse.append(line);
                  sbResponse.append('\r');
                }
                rd.close();

                // return the Json string
                return sbResponse.toString();
            }
            catch (IOException ex ) {
                System.out.println(ex.getMessage());
            }
            return "Did not receive response.";
            }

        
        
}