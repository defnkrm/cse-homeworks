

public class HW02_20230808010 {

    
}
class Ticket{
    private City from;
    private City to;
    private java.util.Date date;
    private int seat;

    Ticket(City from, City to,java.util.Date date,int seat){
        setDate(date);
        setFrom(from);
        setSeat(seat);
        setTo(to);
    }
    Ticket(City from,City to,int seat){
        setTo(to);
        setSeat(seat);
        setFrom(from);
        this.date=new java.util.Date(System.currentTimeMillis()+(24 * 60 * 60 * 1000));
    }


    public java.util.Date getDate() {
        return date;
    }
    public City getFrom() {
        return from;
    }
    public int getSeat() {
        return seat;
    }
    public City getTo() {
        return to;
    }
    public void setDate(java.util.Date date) {
        this.date = date;
    }
    public void setFrom(City from) {
        this.from = from;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public void setTo(City to) {
        this.to = to;
    }
}

class City{
    private String postalCode;
    private String name;

    City(String postalCode,String name){
        setName(name);
        setPostalCode(postalCode);
    }
    public String getName() {
        return name;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
}

class Person{
    private String name;
    private String surname;
    private String phoneNumber;

    Person(String name,String surname,String phoneNumber){
        setName(name);
        setPhoneNumber(phoneNumber);
        setSurname(surname);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getSurname() {
        return surname;
    }
}