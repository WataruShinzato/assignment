package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chbs.objectDir.Booking;
import chbs.objectDir.MyCustomer;
import chbs.typeDir.VaccineVenue;
import chbs.typeDir.Day;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.FlowLayout;

public class CommitteeBookingManage extends JFrame implements ActionListener {
  private Button addBooking, cancelBooking, modifyBooking, searchBooking;

  public CommitteeBookingManage() {
    setSize(500, 250);
    setLocation(700, 500);
    setLayout(new FlowLayout());

    addBooking = new Button("Add Booking");
    cancelBooking = new Button("Cancel Booking");
    modifyBooking = new Button("Modify Booking");
    searchBooking = new Button("Search Booking");

    addBooking.addActionListener(this);
    cancelBooking.addActionListener(this);
    modifyBooking.addActionListener(this);
    searchBooking.addActionListener(this);

    add(addBooking);
    add(cancelBooking);
    add(modifyBooking);
    add(searchBooking);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addBooking) {
      String inputName = JOptionPane.showInputDialog("Username:");
      MyCustomer customer = DataIO.checking(inputName);
      if (customer != null) {
        int size = customer.getMyBookings().size();

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
              JOptionPane.showMessageDialog(addBooking, "Your id is " + id);
              Booking x = new Booking(id, a, b, c, customer);
              DataIO.allBookings.add(x);
              DataIO.write();
            } else {
              JOptionPane.showMessageDialog(addBooking, "Not available!");
            }
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(addBooking, "Wrong input!");
          }
        } else {
          JOptionPane.showMessageDialog(addBooking, "You already have booking!");
        }
      } else {
        JOptionPane.showMessageDialog(addBooking, "There is no name in the booking!");
      }
    } else if (e.getSource() == cancelBooking) {
      String inputName = JOptionPane.showInputDialog("Username :");
      MyCustomer SearchUser = DataIO.checking(inputName);
      System.out.println(SearchUser.getMyBookings().size());
      if (SearchUser.getMyBookings().size() > 0) {
        Booking userBooking = SearchUser.getMyBookings().get(0);
        if (DataIO.allBookings.remove(userBooking) && SearchUser.getMyBookings().remove(userBooking)) {
          DataIO.write();
          JOptionPane.showMessageDialog(cancelBooking, "You removed reservation!");
        } else {
          JOptionPane.showMessageDialog(cancelBooking, "There's no reservation");
        }
      }
    } else if (e.getSource() == modifyBooking) {
      String inputName = JOptionPane.showInputDialog("Username:");
      MyCustomer customer = DataIO.checking(inputName);
      int size = customer.getMyBookings().size();
      int indexOfMyAppoint = DataIO.allBookings.indexOf(customer.getMyBookings().get(0));

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
            int id = customer.getMyBookings().get(0).getId(); // use previous id (not update)
            JOptionPane.showMessageDialog(modifyBooking, "Your id is " + id);
            Booking x = new Booking(id, a, b, c, customer);
            customer.getMyBookings().set(0, x);
            DataIO.allBookings.set(indexOfMyAppoint, x);
            DataIO.write();
          } else {
            JOptionPane.showMessageDialog(modifyBooking, "Not available!");
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(modifyBooking, "Wrong input!");
        }
      }

    } else if (e.getSource() == searchBooking) {
      String inputName = JOptionPane.showInputDialog("Username :");
      MyCustomer searchUser = DataIO.checking(inputName);

      if (searchUser == null) {
        JOptionPane.showMessageDialog(searchBooking, "There's no user in customer");
        return;
      }

      int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));

      if (searchUser.getPassword() != inputPassword) {
        JOptionPane.showMessageDialog(searchBooking, "Wrong password");
        return;
      }

      if (searchUser.getMyBookings().size() > 0) {
        Booking searchUserBooking = searchUser.getMyBookings().get(0);

        String bookingId = String.valueOf(searchUserBooking.getId());
        String bookingVenue = searchUserBooking.getVaccineVenue().toString();
        String bookingDay = searchUserBooking.getDay().toString();
        String bookingTime = String.valueOf(searchUserBooking.getTime());

        String dialogLabel = bookingId + "\n" + bookingVenue + "\n" + bookingDay + "\n" + bookingTime + "\n"
            + "Register: " + inputName;
        JOptionPane.showMessageDialog(searchBooking, dialogLabel);
      } else {
        JOptionPane.showMessageDialog(searchBooking, "There's no booking");

      }
    }
  }
}
