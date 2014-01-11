package exception.handling;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        try {
        int decimal;
        Scanner input = new Scanner(System.in);                         // create an object for reaing input from the console
        System.out.println("Enter a binary number");
        String binary = input.nextLine();
        decimal = binaryToDecimal(binary);                              // call the binaryToDecimal method 
        System.out.println(decimal);
        }
        catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static int binaryToDecimal(String binary) throws BinaryFormatException {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {                     // interate through each digit of binary
            if (binary.charAt(i) == '1') {                              // if the char at the current iteration is 1
                decimal += Math.pow(2, (binary.length() - (i + 1)));    // add the appropriate amount to decimal
            } 
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {   // if char at the current iteration is not a 1 or a 0
                throw new BinaryFormatException();                      // the number is not binary
            }
        }
        
        return decimal;
    }
}
