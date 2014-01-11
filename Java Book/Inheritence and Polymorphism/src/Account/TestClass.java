package Account;

public class TestClass {
    public static void main (String[] args) {
        Account account1 = new SavingsAccount();
        account1.deposit(2500.0);
        account1.deposit(5500.0);
        account1.withdrawal(20);
        System.out.println(account1.toString());
        for ( Transaction t : account1.transactions) {
            System.out.println(t.toString());
        }
    }
}
