package PersonClasses;

public class Student extends Person {
    private String status;
    
    public Student() {
        
    }
    public Student(String name) {
        super(name);
    }
    
    public Student(String name, MyDate dob) {
        super(name, dob);
    }
    
    public Student(String name, MyDate dob, String address) {
        super(name, dob, address);
    }
    
    public Student(String name, MyDate dob, String address, String email) {
        super(name, dob, address, email);
    }
    
    public Student(String name, MyDate dob, String address, String email, String phoneNumber) {
        super(name, dob, address, email, phoneNumber);
    }
    
    public Student(String name, MyDate dob, String address, String email, String phoneNumber, String status) {
        super(name, dob, address, email, phoneNumber);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nStatus: " + status;
    }
}
