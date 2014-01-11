package shapes;

public class Circle extends Square
{
   float radius;
   final float PI = (float) 3.14;
   public Circle(float rad)
   {
      this.radius = rad;
   }
   public float getCircum()
   {
      return 2 * PI * radius;
   }
}
