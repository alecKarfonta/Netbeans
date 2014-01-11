package PersonClasses;

public class Person {
    private String name;
    private MyDate dob;
    private String address;
    private String email;
    private String phoneNumber;
    
    public Person() {
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public Person(String name, MyDate dob) {
        this.name = name;
        this.dob = dob;
    }
    
    public Person(String name, MyDate dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
    }
    
    public Person(String name, MyDate dob, String address, String email) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }
    
    public Person(String name, MyDate dob, String address, String email, String phoneNumber) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }

    public MyDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public String toString() {
        return "Name: " + name;
    }
}
