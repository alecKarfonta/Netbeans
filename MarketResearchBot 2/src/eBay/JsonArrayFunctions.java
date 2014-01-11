package eBay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList; 
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonArrayFunctions {
    
        public static ArrayList<EbayItem> getEbayItemsFromApi(ApiUrl apiUrl) {
            ArrayList<EbayItem> ebayItems = new ArrayList<EbayItem>();
            try {
                // get the initial json object from the api
                JsonObject jsonObject = getJsonObjectFromAPI(apiUrl);

                // get the first array, by name, from the block of json
                JsonArray array = jsonObject.get("findCompletedItemsResponse").getAsJsonArray();        // initial array

                // convert the contents of the array into a json object, only one
                JsonObject arrayObject1 = array.get(0).getAsJsonObject();

                // get the array, by name, from the block of json
                JsonArray array1 = arrayObject1.get("searchResult").getAsJsonArray();                   // search result array

                // convert the contents of the array into a json object, only one
                JsonObject arrayObject2 = array1.get(0).getAsJsonObject();

                // get the  array, by name, from the block of json
                JsonArray itemArray = arrayObject2.get("item").getAsJsonArray();                           // item array

                // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<JsonObject> arrayObjects3 = new ArrayList<JsonObject>();


                /*
                 * // get titles
                 */
                // create array lists to hold the objects and then the arrays of titles
                ArrayList<JsonObject> titleObjects = new ArrayList<JsonObject>();
                ArrayList<JsonArray> titleArrays = new ArrayList<JsonArray>();
                ArrayList<String> titles = new ArrayList<String>();
                int titleLength;
                // loop through the last array assinging each element to a jsonobject then grabing the title arrays
                for (int index = 0; index < itemArray.size(); index++) {
                    titleObjects.add(itemArray.get(index).getAsJsonObject()); //get 0 grabs the first element of each element of arrays3
                    titleArrays.add(titleObjects.get(index).getAsJsonArray("title"));                   // title arrays
                    titleLength = titleArrays.get(index).get(0).toString().length();
                    titles.add(titleArrays.get(index).get(0).toString().substring(1, titleLength - 1));
                    //System.out.println(titles.get(index));               // print title
                }

                
                /*
                 * // get current prices
                 */
                // starting with sellingStatus
                // create an arraylist of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonArray> sellingStatusArrays = new ArrayList<JsonArray>();
                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < itemArray.size(); index++) {
                    arrayObjects3.add(itemArray.get(index).getAsJsonObject());
                    sellingStatusArrays.add(arrayObjects3.get(index).get("sellingStatus").getAsJsonArray());        // sellingStatus' arrays
                }

                // create an arraylist of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonObject> arrayObjects4 = new ArrayList<JsonObject>();
                // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<JsonArray> arrays4 = new ArrayList<JsonArray>();

                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < sellingStatusArrays.size(); index++) {
                    arrayObjects4.add(sellingStatusArrays.get(index).get(0).getAsJsonObject()); 
                    arrays4.add(arrayObjects4.get(index).get("currentPrice").getAsJsonArray());         // current prices arrays
                }

                // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonObject> arrayObjects5 = new ArrayList<JsonObject>();
                // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<String> prices = new ArrayList<String>();

                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < arrays4.size(); index++) {
                    arrayObjects5.add(arrays4.get(index).get(0).getAsJsonObject()); //get 0 grabs the first element
                    prices.add(arrayObjects5.get(index).get("__value__").toString());                   // value arrays
                }            

                String formatString;
                ArrayList<Double> formattedPrices = new ArrayList<Double>();
                for (String entry : prices) {
                    formatString = entry.substring(1, entry.length() - 1);
                    formattedPrices.add(Double.parseDouble(formatString));
                }
                

                /*
                 * // get the sellingStates
                 */
                // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonObject> sellingStateObjects = new ArrayList<JsonObject>();
                // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<JsonArray> sellingStateArrays = new ArrayList<JsonArray>();
                // create an arraylist of strings to hold the selling states
                ArrayList<String> sellingStates = new ArrayList<String>();
                int sellingStateLength;

                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < sellingStatusArrays.size(); index++) {
                    sellingStateObjects.add(sellingStatusArrays.get(index).get(0).getAsJsonObject()); //get 0 grabs the first element of each element of arrays3
                    sellingStateArrays.add(sellingStateObjects.get(index).get("sellingState").getAsJsonArray());         // current prices arrays
                    sellingStateLength = sellingStateArrays.get(index).get(0).toString().length();
                    sellingStates.add(sellingStateArrays.get(index).get(0).toString().substring(1, sellingStateLength - 1));
                }
                
                
                /*
                 * // get condition
                 */
                // starting with condition array
                // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonArray> conditionArrays = new ArrayList<JsonArray>();
                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < itemArray.size(); index++) {
                    arrayObjects3.add(itemArray.get(index).getAsJsonObject());
                    conditionArrays.add(arrayObjects3.get(index).get("condition").getAsJsonArray());        // add condition arrays
                }
                // create an array of JsonObject to hold each conditionid object
                ArrayList<JsonObject> conditionIdObjects = new ArrayList<JsonObject>();
                // Create an arraylist of JSonArrays hold each conditonid array
                ArrayList<JsonArray> conditionIdArrays = new ArrayList<JsonArray>();
                ArrayList<String> conditionIds = new ArrayList<String>();
                
                // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray
                for (int index = 0; index < conditionArrays.size(); index++) {
                    conditionIdObjects.add(conditionArrays.get(index).get(0).getAsJsonObject()); 
                    conditionIdArrays.add(conditionIdObjects.get(index).get("conditionId").getAsJsonArray());         // current prices arrays
                    conditionIds.add(conditionIdArrays.get(index).get(0).toString());
                }


                /*
                 * // add each ebayItem to ebayItems
                 */
                for (int index = 0; index < itemArray.size(); index++) {
                    ebayItems.add(new EbayItem(titles.get(index), formattedPrices.get(index), 
                            sellingStates.get(index), conditionIds.get(index)));
                }
            }
            catch (UnsupportedEncodingException ex) {
                System.out.println(ex.toString());
            }
            catch (NullPointerException ex) {
                System.out.println(ex.toString());
            }
            return ebayItems;
            
        }
            
        
        
       public static JsonObject getJsonObjectFromAPI(ApiUrl apiUrl) throws UnsupportedEncodingException  {
           
           JsonParser parser = new JsonParser();
           JsonObject jsonObject = new JsonObject();
            try { 
                // get the string of json from the server
                String jsonString = getJsonStringFromApi(apiUrl.getUrl());
                                
                // parse the json object from the string
                Object responseObject = parser.parse(jsonString);
                jsonObject = (JsonObject)responseObject;

                } 
            catch(Exception ex) {
                System.out.println("Exception! " + ex.getMessage());
            }
            return jsonObject;
        }
       
       
       public static JsonArray getJsonArrayFromAPI(ApiUrl apiUrl) throws UnsupportedEncodingException  {
           
           JsonParser parser = new JsonParser();
           JsonArray jsonArray = new JsonArray();
            try { 
                // get the string of json from the server
                String jsonString = getJsonStringFromApi(apiUrl.getUrl());
                                
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