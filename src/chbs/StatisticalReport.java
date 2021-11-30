
package chbs;

import chbs.objectDir.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.FlowLayout;

import java.awt.Button;

public class StatisticalReport extends JFrame implements ActionListener {
    private Button searchByAge, searchByGender, searchByWoman;

    public StatisticalReport() {
        setSize(500, 250);
        setLocation(700, 500);
        setLayout(new FlowLayout());

        searchByAge = new Button("Search By Age");
        searchByGender = new Button("Search By Man");

        searchByAge.addActionListener(this);
        searchByGender.addActionListener(this);

        add(searchByAge);
        add(searchByGender);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByAge) {
            String data = "";
            int countOfKids = 0;
            int countOf10 = 0;
            int countOf20 = 0;
            int countOf30 = 0;
            int countOf40 = 0;
            int countOf50 = 0;
            int countOf60 = 0;
            int countOf70 = 0;
            int countOf80 = 0;
            int countOf90 = 0;
            for (int i = 0; i < DataIO.allBookings.size(); i++) {
                Booking booking = DataIO.allBookings.get(i);
                if (booking.getOnwer().getAge() < 10) {
                    countOfKids++;
                } else if (booking.getOnwer().getAge() < 20) {
                    countOf10++;
                } else if (booking.getOnwer().getAge() < 30) {
                    countOf20++;
                } else if (booking.getOnwer().getAge() < 40) {
                    countOf30++;
                } else if (booking.getOnwer().getAge() < 50) {
                    countOf40++;
                } else if (booking.getOnwer().getAge() < 60) {
                    countOf50++;
                } else if (booking.getOnwer().getAge() < 70) {
                    countOf60++;
                } else if (booking.getOnwer().getAge() < 80) {
                    countOf70++;
                } else if (booking.getOnwer().getAge() < 90) {
                    countOf80++;
                } else if (booking.getOnwer().getAge() < 100) {
                    countOf90++;
                }
            }

            int[] numArray = new int[10];
            numArray[0] = countOfKids;
            numArray[1] = countOf10;
            numArray[2] = countOf20;
            numArray[3] = countOf30;
            numArray[4] = countOf40;
            numArray[5] = countOf50;
            numArray[6] = countOf60;
            numArray[7] = countOf70;
            numArray[8] = countOf80;
            numArray[9] = countOf90;

            for (int i = 0; i < 10; i++) {
                String ageName;
                ageName = i == 0 ? "Kids: " : i + "0s: ";
                data += ageName + numArray[i] + "\n";
            }
            JOptionPane.showMessageDialog(searchByAge, data);
        } else if (e.getSource() == searchByGender) {
            int n = 0;
            int m = 0;

            for (int i = 0; i < DataIO.allBookings.size(); i++) {
                Booking booking = DataIO.allBookings.get(i);
                String man = "Man";
                String strval = String.valueOf(booking.getOnwer().getGender());
                if (strval.equals(man)) {
                    n += 1;

                } else {
                    m += 1;
                }

            }
            Integer p = Integer.valueOf(n);
            Integer q = Integer.valueOf(m);
            String summ = p.toString();
            String sumw = q.toString();

            JOptionPane.showMessageDialog(searchByGender, "The number of man:" + summ + "The number of woman:" + sumw);
        } else if (e.getSource() == searchByWoman) {
            String data = "";
            // TODO: 女性の人数を定義
            JOptionPane.showMessageDialog(searchByAge, data);
        }
    }
}
