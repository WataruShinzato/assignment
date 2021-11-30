package chbs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chbs.objectDir.Committee;
import chbs.objectDir.MyCustomer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.FlowLayout;

public class CommitteeManagement extends JFrame implements ActionListener {
    private Button addCommiAccount, deleteCommiAccount, modifyCommiAccount, searchCommiAccount;

    public CommitteeManagement() {
        setSize(500, 250);
        setLocation(700, 500);
        setLayout(new FlowLayout());

        addCommiAccount = new Button("Add UserAccount");
        deleteCommiAccount = new Button("Delete UserAccount");
        modifyCommiAccount = new Button("Edit UserAccount");
        searchCommiAccount = new Button("Search UserAccount");

        addCommiAccount.addActionListener(this);
        deleteCommiAccount.addActionListener(this);
        modifyCommiAccount.addActionListener(this);
        searchCommiAccount.addActionListener(this);

        add(addCommiAccount);
        add(deleteCommiAccount);
        add(modifyCommiAccount);
        add(searchCommiAccount);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCommiAccount) {
            String inputName = JOptionPane.showInputDialog("Committee name:");
            MyCustomer found = DataIO.checking(inputName);
            if (found == null) {
                int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                Committee committee = new Committee(inputName, inputPassword);
                DataIO.allCommittee.add(committee);
                DataIO.write();
                JOptionPane.showMessageDialog(addCommiAccount, inputName + "'s account is registered!");
            } else {
                JOptionPane.showMessageDialog(addCommiAccount, "The username has been used!");
            }
        } else if (e.getSource() == deleteCommiAccount) {
            String inputName = JOptionPane.showInputDialog("Username :");
            Committee found = DataIO.checkingCommittee(inputName);
            if (found == null) {
                JOptionPane.showMessageDialog(deleteCommiAccount, "There is no name");
                return;
            }

            int inputPassword = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
            if (found.getPassword() != inputPassword) {
                JOptionPane.showMessageDialog(deleteCommiAccount, "Wrong password");
                return;
            }

            if (DataIO.allCommittee.remove(found)) {
                DataIO.write();
                JOptionPane.showMessageDialog(deleteCommiAccount, inputName + "'s account has been deleted");
            } else {
                System.out.println("failed to delete");
            }
        } else if (e.getSource() == modifyCommiAccount) {

            String inputName = String.valueOf(JOptionPane.showInputDialog("Name:")); // reinput name from user
            Committee found = DataIO.checkingCommittee(inputName);
            if (found != null) {
                int indexOfMyInfo = DataIO.allCommittee.indexOf(found);

                String inputName2 = String.valueOf(JOptionPane.showInputDialog("New Name:"));
                int password = Integer.parseInt(JOptionPane.showInputDialog("New Password:")); // reinput password from
                                                                                               // user
                Committee updateCommittee = new Committee(inputName2, password);

                found.setName(inputName2); // set inputname
                found.setPassword(password); // set password
                DataIO.allCommittee.set(indexOfMyInfo, updateCommittee); // replace the data before and after the
                                                                         // change.
                DataIO.write(); // write it on people file
            } else {
                JOptionPane.showMessageDialog(modifyCommiAccount, "There is no name");
            }
        } else if (e.getSource() == searchCommiAccount) {
            String inputName = JOptionPane.showInputDialog("Username :");
            Committee searchCommittee = DataIO.checkingCommittee(inputName);
            if (searchCommittee == null) {
                JOptionPane.showMessageDialog(searchCommiAccount, "There's no user in committee!!");
                return;
            }
            String userName = searchCommittee.getName();
            int userPassword = searchCommittee.getPassword();
            JOptionPane.showMessageDialog(searchCommiAccount, userName + " " + userPassword);

        }
    }
}
