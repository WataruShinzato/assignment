package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.FlowLayout;

public class CommitteeUserManage extends JFrame implements ActionListener {
  private Button addUserAccount, cancelUserAccount, modifyUserAccount, searchUserAccount;

  public CommitteeUserManage() {
    setSize(500, 250);
    setLocation(700, 500);
    setLayout(new FlowLayout());

    addUserAccount = new Button("Add UserAccount");
    cancelUserAccount = new Button("Delete UserAccount");
    modifyUserAccount = new Button("Edit UserAccount");
    searchUserAccount = new Button("Search UserAccount");

    addUserAccount.addActionListener(this);
    cancelUserAccount.addActionListener(this);
    modifyUserAccount.addActionListener(this);
    searchUserAccount.addActionListener(this);

    add(addUserAccount);
    add(cancelUserAccount);
    add(modifyUserAccount);
    add(searchUserAccount);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addUserAccount) {
      String inputName = JOptionPane.showInputDialog("Username:");
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
            JOptionPane.showMessageDialog(addUserAccount, "Your id is " + id);
            Booking x = new Booking(id, a, b, c, false, customer);
            DataIO.allBookings.add(x);
            DataIO.write();
          } else {
            JOptionPane.showMessageDialog(addUserAccount, "Not available!");
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(addUserAccount, "Wrong input!");
        }
      } else {
        JOptionPane.showMessageDialog(addUserAccount, "You have unpaid booking!");
      }
    } else if (e.getSource() == cancelUserAccount) { 
      String inputName = JOptionPane.showInputDialog("Username :");
      int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
      MyCustomer customer = new MyCustomer(inputName, inputPassword);
      Booking userBook=null;
      for (Booking userBooking : DataIO.allBookings) {
          if (userBooking.getOnwer().getName().equals(inputName)) {
              userBook = userBooking;
          }
      }
      System.out.println(userBook);
      /*Booking userbBooking = customer.getMyBookings().get(0);
      

            if (customer.getMyBookings().size()>0 && customer.getMyBookings().remove(userbBooking)) {
                DataIO.write();
                JOptionPane.showMessageDialog(cancelBooking, "You removed reservation!");
            } else {
                JOptionPane.showMessageDialog(cancelBooking, "There's no reservation");
            }*/
    } else if (e.getSource() == modifyUserAccount) {
      // TODO
    } else if (e.getSource() == searchUserAccount ) {
      // TODO
    }
  }
}




