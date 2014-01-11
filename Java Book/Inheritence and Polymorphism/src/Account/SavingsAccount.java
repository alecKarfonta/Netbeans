
package Account;

import java.util.Date;

public class SavingsAccount extends Account {
    public SavingsAccount() {
        super();
    }
    
    public SavingsAccount(int id, double balance, double annualInterestRate, Date dateCreated) {
        super(id, balance, annualInterestRate, dateCreated);
    }
    
    @Override
    public double withdrawal(double amount) {
        if ( (balance - amount) < 0) {
            System.out.println("Cannot overdraft account");
        }
        else {
            transactions.add(new Transaction('W', amount, balance, ""));
            balance -= amount;
        }
        return balance;
        
    }
    
    @Override
    public String toString() {
        return "Account Type: Savings\n" + super.toString();
    }
}
