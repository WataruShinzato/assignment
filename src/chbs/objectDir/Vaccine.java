package chbs.objectDir;

public class Vaccine {
    private String day;
    private int time;
    private int quantity;

    public Vaccine(int quantity, String day, int time) {
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
