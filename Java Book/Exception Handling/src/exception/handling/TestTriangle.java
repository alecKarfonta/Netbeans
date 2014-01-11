package exception.handling;

public class TestTriangle {
    public static void main(String[] args) {
        try {
        Triangle triangle = new Triangle(4.0, 4.0, 5.0);
        System.out.println("Triangle made" + triangle.getSide1() + " " + triangle.getSide2() + " " + triangle.getSide3());
        }
        catch (IllegalTriangleException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
}
