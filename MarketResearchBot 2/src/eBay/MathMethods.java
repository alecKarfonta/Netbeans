package eBay;

import java.util.ArrayList;

public class MathMethods {
    public static ArrayList<Double> applyBellCurve(ArrayList<Double> numbers, int stdDevs) {
        double stdDev = getStandardDeviation(numbers);
        double mean = getMean(numbers);
        for (int index = 0; index < numbers.size(); index++) {
            if ( (numbers.get(index) > (mean + (stdDev * stdDevs))) ||
                    (numbers.get(index) < (mean - (stdDev * stdDevs)))) {
                System.out.println("Removed: " + numbers.get(index));
                numbers.remove(index);
            }
        }
        return numbers;
        
    }
    public static double getStandardDeviation(ArrayList<Double> numbers) {
        double mean = getMean(numbers);
        double numerator = 0.0;
        int denominator = numbers.size() - 1;
        
        for (Double number : numbers) {
            numerator += Math.pow((number - mean), 2.0);
        }
        
        return Math.sqrt(numerator/denominator);
    }
    
    public static double getMean(ArrayList<Double> numbers) {
        double total = 0.0;
        for (Double number : numbers) {
            total += number;
        }
        
        return total/numbers.size();
        
    }
}
