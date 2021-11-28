package chbs;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Page3 extends JFrame implements ActionListener { // action after you push people button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stop) {
            System.exit(0);
        } else if (e.getSource() == register) { // action when you push refister button
            String input = JOptionPane.showInputDialog("Committeename:");
            Committee found = DataIO.checkingCommittee(input);
            if (found == null) {
                int a = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                Committee c = new Committee(input, a);
                DataIO.allCommittee.add(c);
                DataIO.write();
            } else {
                JOptionPane.showMessageDialog(register, "The committeename has been used!");
            }
        } else if (e.getSource() == login) { // action when you push login button
            String input = JOptionPane.showInputDialog("committeename:");
            Committee found = DataIO.checkingCommittee(input);
            System.out.println(found);
            if (found != null) {
                int a = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                if (found.getPassword() == a) {
                    CHBS.committee = found;
                    setVisible(false);
                    CHBS.committeeRoute.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                }
            } else {
                JOptionPane.showMessageDialog(login, "You haven't registered!");
            }
        }
    }

    private Button register, login, stop;

    public Page3() {
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
