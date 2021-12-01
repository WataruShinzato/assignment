package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chbs.objectDir.Booking;
import chbs.objectDir.MyCustomer;
import chbs.typeDir.VaccineVenue;
import chbs.typeDir.Day;
import chbs.typeDir.Gender;

public class UserAccountScreen extends JFrame implements ActionListener { // Action after login
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) { // action when you push logout button
            CHBS.login = null;
            setVisible(false);
            CHBS.userAuth.setVisible(true);
        } else if (e.getSource() == booking) { // action when you push booking button
            int size = CHBS.login.getMyBookings().size();
            if (size == 0) {
                try {
                    VaccineVenue a = VaccineVenue.valueOf(JOptionPane.showInputDialog("Vaccine Venue:"));
                    Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if (c < 9 || c > 16) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < DataIO.allBookings.size(); i++) {
                        Booking j = DataIO.allBookings.get(i);
                        if (a.equals(j.getVaccineVenue()) && b.equals(j.getDay()) && c == j.getTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int id = 10001 + DataIO.allBookings.size();
                        JOptionPane.showMessageDialog(booking, "Your id is " + id);
                        Booking x = new Booking(id, a, b, c, CHBS.login);
                        DataIO.allBookings.add(x);
                        CHBS.login.getMyBookings().add(x);
                        DataIO.write();
                    } else {
                        JOptionPane.showMessageDialog(booking, "Not available!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(booking, "Wrong input!");
                }
            } else {
                JOptionPane.showMessageDialog(booking, "You already have booking!");
            }
        } else if (e.getSource() == cancel) { // action when you push cancel button
            Booking searchBooking = DataIO.findBookingByid(); // define

            if (searchBooking != null && CHBS.login.getMyBookings().remove(searchBooking)) {
                DataIO.write();
                JOptionPane.showMessageDialog(cancel, "You removed reservation!");
            } else {
                JOptionPane.showMessageDialog(cancel, "There's no reservation!");
            }

        } else if (e.getSource() == bookingmodify) { // action when you push bookingmodify button
            int size = CHBS.login.getMyBookings().size();
            Booking searchBooking = DataIO.findBookingByid();
            int indexOfMyAppoint = DataIO.allBookings.indexOf(searchBooking);

            if (size > 0) {
                try {
                    VaccineVenue a = VaccineVenue.valueOf(JOptionPane.showInputDialog("Vaccine Venue:"));
                    Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if (c < 9 || c > 16) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < DataIO.allBookings.size(); i++) {
                        Booking j = DataIO.allBookings.get(i);
                        if (a.equals(j.getVaccineVenue()) && b.equals(j.getDay()) && c == j.getTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int id = 10001 + DataIO.allBookings.size();
                        JOptionPane.showMessageDialog(booking, "Your id is " + id);
                        Booking x = new Booking(id, a, b, c, CHBS.login);
                        CHBS.login.getMyBookings().set(0, x);
                        DataIO.allBookings.set(indexOfMyAppoint, x);
                        DataIO.write();
                    } else {
                        JOptionPane.showMessageDialog(booking, "Not available!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(booking, "Wrong input!");
                }
            }

        } else if (e.getSource() == usermodify) { // action when you push usermodify button
            MyCustomer myData = CHBS.login;
            int indexOfMyInfo = DataIO.allCustomers.indexOf(myData);
            String inputName = String.valueOf(JOptionPane.showInputDialog("Name:")); // reinput name from user
            int password = Integer.parseInt(JOptionPane.showInputDialog("Password:")); // reinput password from user
            int age = Integer.parseInt(JOptionPane.showInputDialog("Age:"));
            Gender gender = Gender.valueOf(JOptionPane.showInputDialog("Gender:"));
            MyCustomer updatedMyData = new MyCustomer(inputName, password, age, gender);
            // assign inputname and password to

            myData.setName(inputName); // set inputname
            myData.setPassword(password); // set password
            myData.setAge(age);
            myData.setGender(gender);
            DataIO.allCustomers.set(indexOfMyInfo, updatedMyData); // replace the data before and after the change.
            DataIO.write(); // write it on people file

        } else if (e.getSource() == viewreservation) {
            Booking mybooking = CHBS.login.getMyBookings().get(0); // get booking information of user logged in
            String strday = mybooking.getDay().toString(); // change all elements into string
            String strid = String.valueOf(mybooking.getId());
            String strtime = String.valueOf(mybooking.getTime());
            String strconsul = mybooking.getVaccineVenue().toString();
            String strname = mybooking.getOnwer().getName().toString();

            JOptionPane.showMessageDialog(viewreservation,
                    strday + " " + strid + " " + strtime + " " + strconsul + " " + strname); // display booking

        }
    }

    private Button booking, cancel, logout, usermodify, bookingmodify, viewreservation; // button design

    public UserAccountScreen() {
        setSize(500, 250);
        setLocation(700, 500);
        setLayout(new FlowLayout());
        booking = new Button("Booking");
        cancel = new Button("Cancel");
        logout = new Button("Logout");
        usermodify = new Button("User Modify");
        bookingmodify = new Button("Booking Modify");
        viewreservation = new Button("View Reservation");

        booking.addActionListener(this);
        cancel.addActionListener(this);
        logout.addActionListener(this);
        usermodify.addActionListener(this);
        bookingmodify.addActionListener(this);
        viewreservation.addActionListener(this);
        add(booking);
        add(cancel);
        add(logout);
        add(usermodify);
        add(bookingmodify);
        add(viewreservation);
    }
}
