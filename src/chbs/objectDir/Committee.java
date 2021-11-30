package chbs.objectDir;

import java.util.ArrayList;

public class Committee {
    public static Object Integer;
    private String name;
    private int password;
    private ArrayList<Booking> myBookings = new ArrayList<Booking>();

    // Booking[] myBookings1 = new Booking[10];
    // Booking[] myBookings2 = new Booking[11];
    public Committee(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public ArrayList<Booking> getMyBookings() {
        return myBookings;
    }

    public void setMyBookings(ArrayList<Booking> myBookings) {
        this.myBookings = myBookings;
    }

    public static String valueOf(String showInputDialog) {
        return null;
    }

    public static void set(int i, MyCustomer y) {
    }
}
