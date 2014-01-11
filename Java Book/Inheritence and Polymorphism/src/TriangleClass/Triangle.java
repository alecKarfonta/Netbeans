package TriangleClass;

public class Triangle extends GeometricObject {
    private double side1, side2, side3;
    public Triangle() {
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }
    
    public Triangle(double side1, double side2, double side3)  {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getArea() {
        double p = getPerimeter();
        return (Math.sqrt(p*(p - side1)*(p - side2)*(p - side3)));
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSide1: " + side1 + "\nSide2: " + side2 + "\nSide3: " + side3 + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
                }
    public double getPerimeter() {
        return (side1 + side2 + side3);
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
