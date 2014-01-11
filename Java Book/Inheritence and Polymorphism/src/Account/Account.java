package Account;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    protected double balance;
    protected double annualInterestRate;
    protected Date dateCreated;
    protected ArrayList<Transaction> transactions =  new ArrayList<Transaction>();
    
    public Account() {
    this.id = 0;
    this.balance = 0.0;
    this.annualInterestRate = 0.0;
    this.dateCreated = new Date();
    }
    
    public Account(int id, double balance, double annualInterestRate, Date dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }
    
    public double deposit(double amount) {
        transactions.add(new Transaction('D', amount, balance, ""));
        balance += amount;
        return balance;
    }
    
    public double withdrawal(double amount) {
        transactions.add(new Transaction('W', amount, balance, ""));
        balance -= amount;
        return balance;
    }
    
    @Override
    public String toString() {
        return "Account Number: " + id + "\nBalance: " + balance + "\nDate Created: " + dateCreated.toString();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
}
