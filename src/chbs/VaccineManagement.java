package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VaccineManagement extends JFrame implements ActionListener {
    private Button add, delete, logout, modify, search; // button design

    public VaccineManagement() {
        setSize(500, 250);
        setLocation(700, 500);
        setLayout(new FlowLayout());
        add = new Button("Add");
        delete = new Button("Delete");
        logout = new Button("Logout");
        modify = new Button("Modify");
        search = new Button("Search");

        add.addActionListener(this);
        delete.addActionListener(this);
        logout.addActionListener(this);
        modify.addActionListener(this);
        search.addActionListener(this);

        add(add);
        add(delete);
        add(logout);
        add(modify);
        add(search);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logout) { // action when you push logout button
            CHBS.committee = null;
            setVisible(false);
            CHBS.firstScreen.setVisible(true);
        } else if (e.getSource() == add) { // action when you push booking button
            try {
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Additional Quantity:"));
                Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
                int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                Vaccine x = new Vaccine(quantity, b, c);
                 DataIO.allvaccine.add(x);
                DataIO.write();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(add, "Wrong Input!");
            }
        } else if (e.getSource() == delete) { // action when you push delete button
            Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));   
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine found = DataIO.checkingVaccine(b, c);
            if (DataIO.allvaccine.remove(found)) {
                DataIO.write();
                JOptionPane.showMessageDialog(delete, "deleted");
            } else {
                System.out.println("failed to delete");
            }
                    

        } else if (e.getSource() == modify) { // action when you push bookingmodify button
            Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));   // reinput name from user
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine found = DataIO.checkingVaccine(b, c); 
            if (found != null) {
                int indexOfMyInfo = DataIO.allvaccine.indexOf(found);
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("New Quantity:"));
                Vaccine updatedVaccineData = new Vaccine(quantity, b, c); // assign inputname and password to

                found.setDay(b); // set inputname
                found.setTime(c); // set password
                found.setQuantity(quantity);
                DataIO.allvaccine.set(indexOfMyInfo, updatedVaccineData); // replace the data before and after the change.
                DataIO.write(); // write it on people file
            } else {
                JOptionPane.showMessageDialog(modify, "There is no name");
            }

        } else if (e.getSource() == search) {
            Vaccine vaccine = CHBS.login.getMyBookings().get(0); // get booking information of user logged in
            String dayString = vaccine.getDay().toString(); // change all elements into string
            String quantityString = String.valueOf(vaccine.getQuantity());
            String timeString = String.valueOf(vaccine.getTime());
            // String strpaid = String.valueOf(mybooking.isPaid());

            JOptionPane.showMessageDialog(search,
                    quantityString + " " + dayString + " " + timeString); // display booking

           
        }

    }
}