
package Account;

import java.util.Date;

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    private Transaction() {
    }
    
    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;    
    }
    
    @Override
    public String toString() {
        return "Date: " + date.toString() + "\nType: " + type + "\nAmount: " + amount + "\nBefore balance: " + balance + "\nDescription: " + description;
    }
}
