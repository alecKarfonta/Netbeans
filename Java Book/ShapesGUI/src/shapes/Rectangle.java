package shapes;

public class Rectangle extends Square
{
   float width;
   public Rectangle(float len, float wid)
   {
      length = len;
      width = wid;
   }
   public float getCircum()
   {
      return (length*2)+(width*2);
   }
}