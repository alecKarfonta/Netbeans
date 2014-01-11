package shapes;

public class Square
{
   float length;
   
   public Square() {};
   
   public Square(float len)
   {
      this.length = len;
   }
   public float getCircum()
   {
      return length * 4;
   }
}