package chbs.objectDir;

import chbs.typeDir.Day;

public class Vaccine {
    private Day day;
    private int time;
    private int quantity;

    public Vaccine(int quantity, Day day, int time) {
        this.quantity = quantity;
        this.day = day;
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

}
