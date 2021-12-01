package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chbs.objectDir.Vaccine;

public class VaccineManagement extends JFrame implements ActionListener {
    private Button add, delete, logout, modify, search; // button design

    public VaccineManagement() {
        setSize(500, 250);
        setLocation(700, 500);
        setLayout(new FlowLayout());
        add = new Button("Add Vaccine Data");
        delete = new Button("Delete Vaccine Data");
        logout = new Button("Logout");
        modify = new Button("Modify Vaccine Data");
        search = new Button("Search Vaccine Data");

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
                Date d = new Date();
                SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat time1 = new SimpleDateFormat("HH");
                String b = d1.format(d);
                String time2 = time1.format(d);
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Additional Quantity:"));

                Vaccine x = new Vaccine(quantity, b, Integer.parseInt(time2));
                DataIO.allvaccine.add(x);
                DataIO.write();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(add, "Wrong Input!");
            }
        } else if (e.getSource() == delete) { // action when you push delete button
            String b = JOptionPane.showInputDialog("Day:");
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine found = DataIO.checkingVaccine(b, c);
            if (DataIO.allvaccine.remove(found)) {
                DataIO.write();
                JOptionPane.showMessageDialog(delete, "Deleted!");
            } else {
                System.out.println("Failed to delete!");
            }

        } else if (e.getSource() == modify) { // action when you push bookingmodify button
            String b = JOptionPane.showInputDialog("Day:"); // reinput name from user
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine found = DataIO.checkingVaccine(b, c);
            if (found != null) {
                int indexOfMyInfo = DataIO.allvaccine.indexOf(found);
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("New Quantity:"));
                Vaccine updatedVaccineData = new Vaccine(quantity, b, c); // assign inputname and password to

                found.setDay(b); // set inputname
                found.setTime(c); // set password
                found.setQuantity(quantity);
                DataIO.allvaccine.set(indexOfMyInfo, updatedVaccineData); // replace the data before and after the
                                                                          // change.
                DataIO.write(); // write it on people file
            } else {
                JOptionPane.showMessageDialog(modify, "There is no name!");
            }

        } else if (e.getSource() == search) {
            String b = JOptionPane.showInputDialog("Day:");
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine vaccine = DataIO.checkingVaccine(b, c);
            if (vaccine != null) {
                String dayString = vaccine.getDay().toString(); // change all elements into string
                String quantityString = String.valueOf(vaccine.getQuantity());
                String timeString = String.valueOf(vaccine.getTime());

                JOptionPane.showMessageDialog(search,
                        quantityString + " " + dayString + " " + timeString); // display booking
            } else {
                JOptionPane.showMessageDialog(search, "There is no data!");
            }
        }

    }
}
