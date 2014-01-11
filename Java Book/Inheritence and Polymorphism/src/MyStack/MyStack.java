package MyStack;

import java.util.ArrayList;

public class MyStack extends ArrayList {
    
    public MyStack() {
        
    }
    
    @Override
    public boolean add(Object o) {
        if (this.add(o)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getSize() {
        return this.size();
    }
    
    public Object peek() {
        return this.get(getSize() - 1);
    }
    
    public Object pop() {
        Object o = this.get(this.getSize() - 1);
        this.remove(this.getSize() - 1);
        return o;
    }
    
    public void push(Object o) {
        this.add(o);
    }
    
    public int search(Object o) {
        return this.lastIndexOf(o);
    }
    
    @Override
    public String toString() {
        return "stack: " + this.toString();
    }
}
