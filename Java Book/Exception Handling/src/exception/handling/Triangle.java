package exception.handling;

public class Triangle {
    private double side1, side2, side3;
    public Triangle() { };
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if ((Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)) != side3)) {
            throw new IllegalTriangleException();
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
    
    
}
