package Account;

public class MyDate {
    private int year, month, day;
    public MyDate() {    
        
    }
    
    public MyDate(int year, int month, int day) {
        if(year < 0) {
            System.out.println("Year cannot be negative");
            this.year = 0;
        }
        else {
        this.year = year;
        }
        
        if(month < 1 || month > 12) {
            System.out.println("Month out of bounds");
            month = 0;
        }
        else {
            this.month = month;
        }
        
        if(day < 1 || day > 31) {
            System.out.println("Day out of bounds");
        }
        else {
            this.day = day;
        }
        
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    
       
}
