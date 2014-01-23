package siggrabber3;

public class MyColor implements Comparable<MyColor> {
    private int count;
    private int color;
    
    public MyColor() {
        
    }
    
    public MyColor(int color) {
        this.color = color;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public int getColor() {
        return color;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public void increment() {
        count++;
    }

    @Override
    public int compareTo(MyColor t) {
        return this.count - t.count;
    }
    
}
