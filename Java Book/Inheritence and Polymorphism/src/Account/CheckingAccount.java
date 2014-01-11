package Account;

import java.util.Date;

public class CheckingAccount extends Account {
    private static final double overdraftLimit = 200;
    public CheckingAccount() {
        super();
    }
    
    public CheckingAccount(int id, double balance, double annualInterestRate, Date dateCreated) {
        super(id, balance, annualInterestRate, dateCreated);
    }
    
    @Override
    public double withdrawal(double amount) {
        if ( (balance - amount) < -overdraftLimit ) {                  // Overdraft limit is 200
            System.out.println("Overdraft limit reached");
        }
        else {
            transactions.add(new Transaction('W', amount, balance, ""));
            balance -= amount;
        }
        return balance;
             
    }
}
