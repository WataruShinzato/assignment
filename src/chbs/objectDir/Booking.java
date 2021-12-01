package chbs.objectDir;

import chbs.typeDir.VaccineVenue;
import chbs.typeDir.Day;

public class Booking {
    private int id;
    private VaccineVenue consultant;
    private Day day;
    private int time;
    private MyCustomer onwer;

    public Booking(int id, VaccineVenue consultant, Day day, int time, MyCustomer onwer) {
        this.id = id;
        this.consultant = consultant;
        this.day = day;
        this.time = time;
        this.onwer = onwer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VaccineVenue getVaccineVenue() {
        return consultant;
    }

    public void setVaccineVenue(VaccineVenue consultant) {
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

    public MyCustomer getOnwer() {
        return onwer;
    }

    public void setOnwer(MyCustomer onwer) {
        this.onwer = onwer;
    }
}
