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
        search= new Button("Search");

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
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == logout) { // action when you push logout button
            CHBS.login = null;
            setVisible(false);
            CHBS.first.setVisible(true);
        } else if (e.getSource() == add) { // action when you push booking button
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Additional Quantity:"));
            Day b = Day.valueOf(JOptionPane.showInputDialog("Day:"));
            int c = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
            Vaccine x = new Vaccine(quantity, b, c);
            DataIO.allvaccine.add(x);
            DataIO.write();
        } else if (e.getSource() == delete) { // action when you push cancel button
            

        } else if (e.getSource() == modify) { // action when you push bookingmodify button
            

        } else if (e.getSource() == search) {
            
        }

    }
}







    

