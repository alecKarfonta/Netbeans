package exception.handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        int operand1 = 0;
        int operand2 = 0;
        int result = 0;
        String operation = "";
        
        try {
        operand1 = input.nextInt();
        operation = input.next();
        operand2 = input.nextInt();
        
        result = operate(operand1, operation, operand2);
        
        }
        catch (InputMismatchException ex) {
            System.out.println("Please use format: int operation int");
        }
        
        System.out.println(operand1 + " " + operation + " " + operand2 + " = " + result);
        
    }
    
    public static int operate(int operand1, String operation, int operand2) {
        int result = 0;
        switch (operation.charAt(0)) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        
        return result;
    }
}
