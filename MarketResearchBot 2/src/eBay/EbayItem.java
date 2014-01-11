package eBay;

import java.text.NumberFormat;

/**
 *
 * @author aj9027
 */
public class EbayItem {
    NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
    protected String title;
    protected Double price;
    protected String sellingState;
    protected String condition;
    
    public EbayItem() {
        
    }
    
    public EbayItem(String title, String price, String sellingState, String condition) {
        this.title = title;
        this.price = Double.parseDouble(price);
        this.sellingState = sellingState;
        this.condition = condition;
    }
    
    public EbayItem(String title, Double price, String sellingState, String condition) {
        this.title = title;
        this.price = price;
        this.sellingState = sellingState;
        this.condition = condition;
    }
    
    public boolean isSold() {
        if (sellingState.matches("EndedWithSales")) {
            return true;
        }
        if (sellingState.matches("EndedWithoutSales")) {
            return false;
        }
        System.out.println("Did not recognize selling state in EbayItem.java");
        return false;
    }
    

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
    public String getSellingState() {
        return sellingState;
    }

    public String getCondition() {
        return condition;
    }
}
