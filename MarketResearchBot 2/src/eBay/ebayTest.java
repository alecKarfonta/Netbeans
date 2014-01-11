package eBay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author aj9027
 */
public class ebayTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        // search keyword
        String searchTerm = "logitech mk710 keyboard";
        
        String ebayApiFunction = "findCompletedItems";
        /*
         * Build an ApiUrl for the 
         */
        String url = "http://svcs.ebay.com/services/search/FindingService/v1";
        String charset = "UTF-8";                                                          // search term for product defined
        String appID = "AlecKarf-c751-4170-85db-6d95d55e7c73";                             // api key
        String urlParams = "OPERATION-NAME=" + ebayApiFunction          
                + "&SERVICE-VERSION=" + URLEncoder.encode("1.7.0", charset) 
                + "&SECURITY-APPNAME=" + URLEncoder.encode(appID, charset)
                + "&RESPONSE-DATA-FORMAT=" + URLEncoder.encode("Json", charset)
                + "&REST-PAYLOAD" 
                + "&keywords=" + URLEncoder.encode(searchTerm, charset);                    // search term used
                
        ApiUrl ebayApiUrl = new ApiUrl(url,urlParams);
        //System.out.println(ebayApiUrl.getUrl());                                          // Print Url
        
        try {
                    // get the initial json object from the api
                JsonObject jsonObject = JsonArrayFunctions.getJsonObjectFromAPI(ebayApiUrl);
                
                    // get the first array, by name, from the block of json    
                JsonArray array = jsonObject.get("findCompletedItemsResponse").getAsJsonArray();
                
                    // convert the contents of the array into a json object, only one    
                JsonObject arrayObject1 = array.get(0).getAsJsonObject();
            
                    // get the array, by name, from the block of json
                JsonArray array1 = arrayObject1.get("searchResult").getAsJsonArray();
                
                    // convert the contents of the array into a json object, only one    
                JsonObject arrayObject2 = array1.get(0).getAsJsonObject();
                
                    // get the  array, by name, from the block of json    
                JsonArray array2 = arrayObject2.get("item").getAsJsonArray();
                
                    // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<JsonObject> arrayObjects3 = new ArrayList<JsonObject>();
                
                    // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonArray> arrays3 = new ArrayList<JsonArray>();
            
                    // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray   
                for (int index = 0; index < array2.size(); index++) {
                    arrayObjects3.add(array2.get(index).getAsJsonObject());
                    //System.out.println(arrayObjects3[index]);
                    arrays3.add(arrayObjects3.get(index).get("sellingStatus").getAsJsonArray());
                }
                
                    // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonObject> arrayObjects4 = new ArrayList<JsonObject>();
                    // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<JsonArray> arrays4 = new ArrayList<JsonArray>();
                
                    // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray 
                for (int index = 0; index < arrays3.size() - 1; index++) {
                    arrayObjects4.add(arrays3.get(index).get(0).getAsJsonObject()); //get 0 grabs the first element of each element of arrays3
                    arrays4.add(arrayObjects4.get(index).get("currentPrice").getAsJsonArray());
                }
                
                    // create an array of JsonArrays to hold each array from the last JsonArray
                ArrayList<JsonObject> arrayObjects5 = new ArrayList<JsonObject>();
                    // Create an arraylist of JSonObjcts to strore each element of the last JsonArray
                ArrayList<String> prices = new ArrayList<String>();
                
                    // loop through the last array assigning each element to a JsonObject then converting it to a JsonArray 
                for (int index = 0; index < arrays4.size() - 1; index++) {
                    arrayObjects5.add(arrays4.get(index).get(0).getAsJsonObject()); //get 0 grabs the first element
                    prices.add(arrayObjects5.get(index).get("__value__").toString());
                }
                
                String formatString = "";
                ArrayList<Double> formattedPrices = new ArrayList<Double>();
                for (String entry : prices) {
                    formatString = entry.substring(1, entry.length() - 1);
                    formattedPrices.add(Double.parseDouble(formatString));
                }
                
                double total = 0.0;
                for (Double price : formattedPrices ) {
                    total+= price;
                }
                
                double average = total / formattedPrices.size();
                System.out.println("Average: " + average);
                System.out.println("Total Sold: " + formattedPrices.size());
                
                
        }
        catch (UnsupportedEncodingException ex) {
            System.out.println(ex.toString());
        }
        
        
    }
}
