package exception.handling;

public class BinaryFormatException extends NumberFormatException {
    public BinaryFormatException() {
        
    }
    @Override
    public String getMessage() {
        return "This is not a Binary Number";
    }
}
