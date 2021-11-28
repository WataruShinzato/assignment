package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Page2 extends JFrame implements ActionListener { // Action after login
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) { // action when you push logout button
            CHBS.login = null;
            setVisible(false);
            CHBS.first.setVisible(true);
        } else if (e.getSource() == booking) { // action when you push booking button
            int size = CHBS.login.getMyBookings().size();
            if (size == 0 || CHBS.login.getMyBookings().get(size - 1).isPaid()) {
                try {
                    Consultant a = Consultant.valueOf(JOptionPane.showInputDialog("Consultant:"));
                    Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if (c < 9 || c > 16) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < DataIO.allBookings.size(); i++) {
                        Booking j = DataIO.allBookings.get(i);
                        if (a.equals(j.getConsultant()) && b.equals(j.getDay()) && c == j.getTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int id = 10001 + DataIO.allBookings.size();
                        JOptionPane.showMessageDialog(booking, "Your id is " + id);
                        Booking x = new Booking(id, a, b, c, false, CHBS.login);
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
                JOptionPane.showMessageDialog(booking, "You have unpaid booking!");
            }
        } else if (e.getSource() == cancel) { // action when you push cancel button
            Booking searchBooking = DataIO.findBookingByid(false); // define unpaid

            if (searchBooking != null && CHBS.login.getMyBookings().remove(searchBooking)) {
                DataIO.write();
                JOptionPane.showMessageDialog(cancel, "You removed reservation!");
            } else {
                JOptionPane.showMessageDialog(cancel, "There's no reservation");
            }

        } else if (e.getSource() == bookingmodify) { // action when you push bookingmodify button
            int size = CHBS.login.getMyBookings().size();
            Booking searchBooking = DataIO.findBookingByid(false);
            int indexOfMyAppoint = DataIO.allBookings.indexOf(searchBooking);

            if (size > 0) {
                try {
                    Consultant a = Consultant.valueOf(JOptionPane.showInputDialog("Consultant:"));
                    Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if (c < 9 || c > 16) {
                        throw new Exception();
                    }
                    boolean flag = true;
                    for (int i = 0; i < DataIO.allBookings.size(); i++) {
                        Booking j = DataIO.allBookings.get(i);
                        if (a.equals(j.getConsultant()) && b.equals(j.getDay()) && c == j.getTime()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int id = 10001 + DataIO.allBookings.size();
                        JOptionPane.showMessageDialog(booking, "Your id is " + id);
                        Booking x = new Booking(id, a, b, c, false, CHBS.login);
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

            // MyCustomer searchCustomer = DataIO.checking(getName());
            MyCustomer myData = CHBS.login;
            int indexOfMyInfo = DataIO.allCustomers.indexOf(myData);
            String inputName = String.valueOf(JOptionPane.showInputDialog("Name:")); // reinput name from user
            int password = Integer.parseInt(JOptionPane.showInputDialog("Password:")); // reinput password from user
            MyCustomer updatedMyData = new MyCustomer(inputName, password); // assign inputname and password to

            myData.setName(inputName); // set inputname
            myData.setPassword(password); // set password
            DataIO.allCustomers.set(indexOfMyInfo, updatedMyData); // replace the data before and after the change.
            DataIO.write(); // write it on people file

        } else if (e.getSource() == viewreservation) {
            Booking mybooking = CHBS.login.getMyBookings().get(0); // get booking information of user logged in
            String strday = mybooking.getDay().toString(); // change all elements into string
            String strid = String.valueOf(mybooking.getId());
            String strtime = String.valueOf(mybooking.getTime());
            String strconsul = mybooking.getConsultant().toString();
            String strname = mybooking.getOnwer().getName().toString();
            // String strpaid = String.valueOf(mybooking.isPaid());

            JOptionPane.showMessageDialog(viewreservation,
                    strday + " " + strid + " " + strtime + " " + strconsul + " " + strname); // display booking

        }
    }

    private Button booking, cancel, logout, usermodify, bookingmodify, viewreservation; // button design

    public Page2() {
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
