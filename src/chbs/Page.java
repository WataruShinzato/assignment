package chbs;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Page extends JFrame implements ActionListener{ //First button action
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == people){                         // action when you push people button
            setVisible(false);
            CHBS.first.setVisible(true);
            
        } else if(e.getSource() == committee){               // action when you push perssnel button
            
            setVisible(false);
            CHBS.third.setVisible(true);
                
        }
    }
    private Button people, committee ;                      //button design
    public Page(){
        setSize(250,100);
        setLocation(700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //components will be added one by one from left to right
        //top to bottom & center alignment
        people = new Button("People");
        committee = new Button("Committee");
        
        //this is the current object -> first
        people.addActionListener(this);
        committee.addActionListener(this);
      
        add(people);
        add(committee);
       
        setVisible(true);
    }
}
