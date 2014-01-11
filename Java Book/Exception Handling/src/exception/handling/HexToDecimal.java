package exception.handling;

import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int decimal = 0;
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        
        try {
            decimal = hexToDecimal(hex);
            System.out.println(decimal);
        }
        catch (NumberFormatException ex) {
            System.out.println("Not a hex number.");
        }
        
    }
    
    public static int hexToDecimal(String hex) throws NumberFormatException {
        if (hex.charAt(0) > 'F' || hex.charAt(0) < 'A') {
            throw new NumberFormatException();
        }
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
        char hexChar = hex.charAt(i);
        decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar); 
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        }
        else {
            return ch - '0';
        }
    }
}
