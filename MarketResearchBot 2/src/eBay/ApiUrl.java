package eBay;

public class ApiUrl {
    protected StringBuilder url = new StringBuilder();;
    protected String charset;
    protected String appID;
    protected StringBuilder params = new StringBuilder(); 
    protected String description;
    
    public ApiUrl() {
    }
    
    public ApiUrl(String url) {
        this.url.append(url);
        System.out.println("Constructor 1");
    }
    
    public ApiUrl(String url, String params) {
        this.url.append(url);
        this.params.append(params);
    }
    
    public ApiUrl(String url, String params, String description) {
        this.url.append(url);
        this.params.append(params);
        this.description = description;
    }
    
    public String getUrl() {
        if (this.params.length() != 0) {
            //System.out.println("Length of params was not zero");
            return url.toString() + "?" + params.toString();
            
        }
        return url.toString();
    }
    
    public String getDescription() {
        return description;
    }
    
    public void appendToUrl(String text) {
        this.url.append(text);
    }
    
    public void appendToParams(String text) {
        this.url.append(text);
    }
    
    
    
}
