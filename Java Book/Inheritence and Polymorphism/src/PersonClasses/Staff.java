
package PersonClasses;

public class Staff extends Employee {
    private String title;
    public Staff() {
        
    }
    public Staff(String name) {
        super(name);
    }
    
    public Staff(String name, MyDate dob) {
        super(name, dob);
    }
    
    public Staff(String name, MyDate dob, String address) {
        super(name, dob, address);
    }
    
    public Staff(String name, MyDate dob, String address, String email) {
        super(name, dob, address, email);
    }
    
    public Staff(String name, MyDate dob, String address, String email, String phoneNumber) {
        super(name, dob, address, email, phoneNumber);
    }
    
    public Staff(String name, MyDate dob, String address, String email, String phoneNumber, String office, int salary, MyDate dateHired, String title) {
        super(name, dob, address, email, phoneNumber, office, salary, dateHired);
        this.title = title;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTitle: " + title;
    }
}
