package shapes;

public class Triangle extends Square
{
    float side, side2, side3;
   public Triangle(float side, float side2, float side3)
   {
      this.side = side;
      this.side2 = side2;
      this.side3 = side3;
   }
   public float getCircum()
   {
      return side + side2 + side3;
   }
}