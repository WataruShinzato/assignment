package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    setVisible(false);
    if (e.getSource() == addBooking) {
      String inputName = JOptionPane.showInputDialog("Committeename:");
      int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
      MyCustomer customer = new MyCustomer(inputName, inputPassword);
      int size = customer.getMyBookings().size();
      if (size == 0 || customer.getMyBookings().get(size - 1).isPaid()) {
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
            JOptionPane.showMessageDialog(addBooking, "Your id is " + id);
            Booking x = new Booking(id, a, b, c, false, customer);
            DataIO.allBookings.add(x);
            DataIO.write();
          } else {
            JOptionPane.showMessageDialog(addBooking, "Not available!");
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(addBooking, "Wrong input!");
        }
      } else {
        JOptionPane.showMessageDialog(addBooking, "You have unpaid booking!");
      }
    } else if (e.getSource() == cancelBooking) {
      // TODO
    } else if (e.getSource() == modifyBooking) {
      // TODO
    } else if (e.getSource() == searchBooking) {
      // TODO
    }
  }
}
