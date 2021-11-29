package chbs;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.FlowLayout;

public class CommitteeRoute extends JFrame implements ActionListener {
  private Button bookingManagement, userManagement, vaccinationManagement, committeeManagement, statisticalReport;

  public CommitteeRoute() {
    setSize(250, 100);
    setLocation(700, 500);
    setLayout(new FlowLayout());

    bookingManagement = new Button("Booking Manage");
    userManagement = new Button("User Manage");
    vaccinationManagement = new Button("User Manage");
    committeeManagement = new Button("User Manage");
    statisticalReport = new Button("User Manage");

    bookingManagement.addActionListener(this);
    userManagement.addActionListener(this);
    vaccinationManagement.addActionListener(this);
    committeeManagement.addActionListener(this);
    statisticalReport.addActionListener(this);

    add(bookingManagement);
    add(userManagement);
    add(vaccinationManagement);
    add(committeeManagement);
    add(statisticalReport);
  }

  public void actionPerformed(ActionEvent e) {
    setVisible(false);
    if (e.getSource() == bookingManagement) {
      CHBS.committeeBookingManage.setVisible(true);
    } else if (e.getSource() == userManagement) {
      CHBS.committeeUserManage.setVisible(true);
    } else if (e.getSource() == vaccinationManagement) {
      // TODO: move vaccinationScreen
    } else if (e.getSource() == committeeManagement) {
      // TODO: move committeeManagementScreen
    } else if (e.getSource() == statisticalReport) {
      // TODO: move statisticalReportScreen
    }
  }
}
