package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chbs.objectDir.MyCustomer;
import chbs.typeDir.Gender;

public class UserAuth extends JFrame implements ActionListener { // action after you push people button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stop) { // action when you push stop button
            System.exit(0);
        } else if (e.getSource() == register) { // action when you push refister button
            String input = JOptionPane.showInputDialog("Username:");
            MyCustomer found = DataIO.checking(input);
            if (found == null) {
                try {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Age:"));
                    Gender gender = Gender.valueOf(JOptionPane.showInputDialog("Gender:"));
                    MyCustomer c = new MyCustomer(input, a, age, gender);
                    DataIO.allCustomers.add(c);
                    DataIO.write();
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(login, "Wrong input");
                }
            } else {
                JOptionPane.showMessageDialog(register, "The username has been used!");
            }
        } else if (e.getSource() == login) { // action when you push login button
            String input = JOptionPane.showInputDialog("Username:");
            MyCustomer found = DataIO.checking(input);
            if (found != null) {
                int a = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                if (found.getPassword() == a) {
                    CHBS.login = found;
                    setVisible(false);
                    CHBS.second.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                }
            } else {
                JOptionPane.showMessageDialog(login, "You haven't registered!");
            }
        }
    }

    private Button register, login, stop; // button design

    public UserAuth() {
        setSize(250, 100);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // components will be added one by one from left to right
        // top to bottom & center alignment
        register = new Button("Register");
        login = new Button("Login");
        stop = new Button("Stop");
        // this is the current object -> first
        register.addActionListener(this);
        login.addActionListener(this);
        stop.addActionListener(this);
        add(register);
        add(login);
        add(stop);

    }
}
