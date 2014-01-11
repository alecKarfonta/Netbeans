package exception.handling;

public class TestLoan {
    public static void main(String[] args) {
        try {
        Loan loan = new Loan(0,1,1);
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Illegal Argument: " + ex.getMessage());
        }
    }
}
