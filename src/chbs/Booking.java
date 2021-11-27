package chbs;
public class Booking {
    private int id;
    private Consultant consultant;
    private Day day;
    private int time;
    private boolean paid;
    private MyCustomer onwer;   
    public Booking(int id, Consultant consultant, Day day, int time, boolean paid, MyCustomer onwer) {
        this.id = id;
        this.consultant = consultant;
        this.day = day;
        this.time = time;
        this.paid = paid;
        this.onwer = onwer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Consultant getConsultant() {
        return consultant;
    }
    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }
    public Day getDay() {
        return day;
    }
    public void setDay(Day day) {
        this.day = day;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public MyCustomer getOnwer() {
        return onwer;
    }
    public void setOnwer(MyCustomer onwer) {
        this.onwer = onwer;
    }
}
