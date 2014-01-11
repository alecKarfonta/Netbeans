
package exception.handling;


public class IllegalTriangleException extends Exception {
    @Override
    public String getMessage() {
        return "These sides cannot form a triangle.";
    }
}
