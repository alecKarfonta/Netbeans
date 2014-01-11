package PersonClasses;

public class Employee extends Person {
    private String office;
    private int salary;
    private MyDate  dateHired;
    
    public Employee() {
        
    }
    public Employee(String name) {
        super(name);
    }
    
    public Employee(String name, MyDate dob) {
        super(name, dob);
    }
    
    public Employee(String name, MyDate dob, String address) {
        super(name, dob, address);
    }
    
    public Employee(String name, MyDate dob, String address, String email) {
        super(name, dob, address, email);
    }
    
    public Employee(String name, MyDate dob, String address, String email, String phoneNumber) {
        super(name, dob, address, email, phoneNumber);
    }
    
    public Employee(String name, MyDate dob, String address, String email, String phoneNumber, String office, int salary, MyDate dateHired) {
        super(name, dob, address, email, phoneNumber);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nOffice: " + office;
    }
}
