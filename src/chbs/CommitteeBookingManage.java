package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
      int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
      //MyCustomer customer = new MyCustomer(inputName, inputPassword);
      MyCustomer customer = DataIO.checking(inputName);
      if(customer!= null){
        int size = customer.getMyBookings().size();
        
        if(size == 0 || customer.getMyBookings().get(size - 1).isPaid()) {
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
      } else{
        JOptionPane.showMessageDialog(addBooking, "There is no name in the booking!");
      }
    } else if (e.getSource() == cancelBooking) {
      String inputName = JOptionPane.showInputDialog("Username :");
      // MyCustomer customer = new MyCustomer(inputName, inputPassword);
      // for (Booking userBooking : DataIO.allBookings) {
      // if (userBooking.getOnwer().getName().equals(inputName)) {
      // userBook = userBooking;
      // break;
      // }
      // userBook = null;
      // }
      MyCustomer SearchUser = DataIO.checking(inputName);
      System.out.println(SearchUser.getMyBookings().size());
      if(SearchUser.getMyBookings().size()>0){
        Booking userBooking = SearchUser.getMyBookings().get(0);
        if(DataIO.allBookings.remove(userBooking) && SearchUser.getMyBookings().remove(userBooking)){
          DataIO.write();
          JOptionPane.showMessageDialog(cancelBooking, "You removed reservation!");
        }else{
          JOptionPane.showMessageDialog(cancelBooking, "There's no reservation");
        }
      }
      /*
       * Booking userbBooking = customer.getMyBookings().get(0);
       * 
       * 
       * if (customer.getMyBookings().size()>0 &&
       * customer.getMyBookings().remove(userbBooking)) {
       * DataIO.write();
       * JOptionPane.showMessageDialog(cancelBooking, "You removed reservation!");
       * } else {
       * JOptionPane.showMessageDialog(cancelBooking, "There's no reservation");
       * }
       */
    } else if (e.getSource() == modifyBooking) {
      String inputName = JOptionPane.showInputDialog("Username:");
      MyCustomer customer = DataIO.checking(inputName);
      int size = customer.getMyBookings().size();
      int indexOfMyAppoint = DataIO.allBookings.indexOf(customer.getMyBookings().get(0));

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
                  //int id = 10001 + DataIO.allBookings.size();
                  int id = customer.getMyBookings().get(0).getId();   // use previous id (not update)
                  JOptionPane.showMessageDialog(modifyBooking, "Your id is " + id);
                  Booking x = new Booking(id, a, b, c, false, customer);
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
      // TODO
    }
  }
}
