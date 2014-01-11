package PersonClasses;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;
    
    public Faculty() {
        
    }
    public Faculty(String name) {
        super(name);
    }
    
    public Faculty(String name, MyDate dob) {
        super(name, dob);
    }
    
    public Faculty(String name, MyDate dob, String address) {
        super(name, dob, address);
    }
    
    public Faculty(String name, MyDate dob, String address, String email) {
        super(name, dob, address, email);
    }
    
    public Faculty(String name, MyDate dob, String address, String email, String phoneNumber) {
        super(name, dob, address, email, phoneNumber);
    }
    
    public Faculty(String name, MyDate dob, String address, String email, String phoneNumber, String office, int salary, MyDate dateHired, String officeHours, String rank) {
        super(name, dob, address, email, phoneNumber, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nRank: " + rank + "\nOffice Hours: " + officeHours;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    
}