
package chbs;

import java.awt.event.*;

import javax.swing.JOptionPane;

import java.awt.Button;

public class StatisticalReport {
    private Button searchByAge;

    public StatisticalReport() {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByAge) {
            String data = "";
            // 下のやつを一行ずつ String にまとめてそこに出す
            // 10代何名？
            // 20代何名？
            // 30代何名？
            // 40代何名？
            for (int i = 0; i < 8; i++) {

            }
            JOptionPane.showMessageDialog(searchByAge, data);
        } else if (e.getSource() == searchByAge) {
            String data = "";
            // TODO: 男性の人数を定義
            JOptionPane.showMessageDialog(searchByAge, data);
        } else if (e.getSource() == searchByAge) {
            String data = "";
            // TODO: 女性の人数を定義
            JOptionPane.showMessageDialog(searchByAge, data);
        }
    }
}
