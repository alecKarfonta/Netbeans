package exception.handling;

import java.util.Date;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        int number = 0;
        int primeCount = 0;
        Scanner input = new Scanner(System.in);                         // Create a scanner object to recieve input from the console
        System.out.println("Enter a number to find all the prime numbers less than it.");
        number = input.nextInt();
        Date startTime = new Date();                                    // begin counting ms
        System.out.println("# - Prime");
        for (int index = 1; index <= number; index++) {
            if (isPrime(index)) {                                       // check if the the index is prime using the isPrime method
                System.out.println(++primeCount + " - " + index);       // print the primeCount, after iterating it, and
                                                                        // the index to a single line
            }
        }
        
        System.out.println("Prime Count: " + primeCount);               
        Date endTime = new Date();                                      // stop counting
        System.out.println("Computing time(ms): " + (endTime.getTime() - startTime.getTime()));
        
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1)  {                                             // if the number is less than or equal to one
            return false;                                               // it is not prime
        }
        if (number == 2) {                                              // if the number is 2
            return true;                                                // it is prime
        }
        for (int numeral = 2; numeral <= Math.sqrt(number); numeral++) {
                if (number % numeral == 0) {   // if the index is divisble by the numeral 
                    return false;                                       // the number is not prime
                }    
            }
        
                                                                        // if it was not 1 or a number that is divisible by 
       return true;                                                     // another then it prime
    }
}
