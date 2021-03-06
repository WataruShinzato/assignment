package chbs.objectDir;

import java.util.ArrayList;

import chbs.typeDir.Gender;

public class MyCustomer extends Committee {
    public static Object Integer;
    private int age;
    private Gender gender;
    private ArrayList<Booking> myBookings = new ArrayList<Booking>();

    public MyCustomer(String name, int password, int age, Gender gender) {
        super(name, password);
        this.age = age;
        this.gender = gender;
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
