package chbs;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.FlowLayout;

public class CommitteeRoute extends JFrame implements ActionListener {
  private Button bookingManagement, userManagement;

  public CommitteeRoute() {
    setSize(250, 100);
    setLocation(700, 500);
    setLayout(new FlowLayout());

    bookingManagement = new Button("Booking Manage");
    userManagement = new Button("User Manage");

    bookingManagement.addActionListener(this);
    userManagement.addActionListener(this);

    add(bookingManagement);
    add(userManagement);
  }

  public void actionPerformed(ActionEvent e) {
    setVisible(false);
    if (e.getSource() == bookingManagement) {
      CHBS.committeeScreen.setVisible(true);
    } else {
      CHBS.committeeScreen.setVisible(true);
    }
  }
}
