package exception.handling;

import java.util.Scanner;

public class IndexOutOfBounds {
    public static void main(String[] args) {
        int[] intArray = new int[100];
        Scanner input = new Scanner(System.in);
        int index;
        
        // initialize array
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int)(Math.random() * 100);
        }
        
        System.out.println("Enter an index to find its value");
        index = input.nextInt();
        
        try {
            System.out.println(intArray[index]);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Error: " + ex.getMessage() + "is out of bounds.");
            System.out.println("Please try again.");
            index = input.nextInt();
            System.out.println(intArray[index]);
        }
    }
}
