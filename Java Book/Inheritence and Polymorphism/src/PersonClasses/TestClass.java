package PersonClasses;

public class TestClass {
    public static void main(String[] args) {
        Person person = new Student("Alec");
        ((Student)person).setStatus("Junior");
        System.out.println(((Student)person).toString());
        
    }
}
