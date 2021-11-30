package chbs;

import java.util.ArrayList;

public class MyCustomer {
    public static Object Integer;
    private String name;
    private int password;
    private int age;
    private Gender gender;
    private ArrayList<Booking> myBookings = new ArrayList<Booking>();

    public MyCustomer(String name, int password, int age, Gender gender) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
