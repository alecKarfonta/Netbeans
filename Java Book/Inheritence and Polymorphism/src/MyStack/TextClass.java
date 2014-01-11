package MyStack;

public class TextClass {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add("GO!");
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        stack.add("Countdown");
        int size = stack.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}
