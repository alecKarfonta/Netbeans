package exception.handling;

public class OutOfMemory {
    public static void main(String[] args) {
        
        try{
        double[] doubleArray = new double[13741943];
        
        
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Math.random();
        }
        }
        catch (OutOfMemoryError ex) {
            System.out.println("Out of Memory");
        }
     }
}
