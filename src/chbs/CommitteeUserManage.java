package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
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
      MyCustomer found = DataIO.checking(inputName);
      if (found == null) {
        int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
        MyCustomer newCustomer = new MyCustomer(inputName, inputPassword);
        DataIO.allCustomers.add(newCustomer);
        DataIO.write();
        JOptionPane.showMessageDialog(addUserAccount, inputName + "'s account is registered!");
      } else {
        JOptionPane.showMessageDialog(addUserAccount, "The username has been used!");
      }
    } else if (e.getSource() == cancelUserAccount) {
      String inputName = JOptionPane.showInputDialog("Username :");

      Booking userBook = null;
      for (Booking userBooking : DataIO.allBookings) {
        if (userBooking.getOnwer().getName().equals(inputName)) {
          userBook = userBooking;
        }
      }
      System.out.println(userBook);
    } else if (e.getSource() == modifyUserAccount) {
            
            String inputName = String.valueOf(JOptionPane.showInputDialog("Name:")); // reinput name from user
            MyCustomer found = DataIO.checking(inputName);
            if (found !=null){
              int indexOfMyInfo = DataIO.allCustomers.indexOf(found);
              String inputName2 = String.valueOf(JOptionPane.showInputDialog("New Name:"));
              int password = Integer.parseInt(JOptionPane.showInputDialog("New Password:")); // reinput password from user
              MyCustomer updatedMyData = new MyCustomer(inputName2, password); // assign inputname and password to

              found.setName(inputName2); // set inputname
              found.setPassword(password); // set password
              DataIO.allCustomers.set(indexOfMyInfo, updatedMyData); // replace the data before and after the change.
              DataIO.write(); // write it on people file
            }else{
              JOptionPane.showMessageDialog(modifyUserAccount,"There is no name");
            }
    } else if (e.getSource() == searchUserAccount) {
      String inputName = JOptionPane.showInputDialog("Username :");
      MyCustomer searchUser = DataIO.checking(inputName);

      if (searchUser == null) {
        JOptionPane.showMessageDialog(searchUserAccount, "There's no user in customer");
        return;
      }
      String userName = searchUser.getName();
      int userPassword = searchUser.getPassword();
      JOptionPane.showMessageDialog(searchUserAccount,userName+" "+ userPassword);

      
      

    }
  }
}
