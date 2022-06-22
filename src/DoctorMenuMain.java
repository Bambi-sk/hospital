import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorMenuMain extends Container {
    public JButton add_bill;
    public JButton list_reserve;
    public DoctorMenuMain() {
        setSize(700, 700);
        setLayout(null);
        add_bill = new JButton("Add bill");
        add_bill.setLocation(200, 150);
        add_bill.setSize(300, 30);
        add_bill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctor_main.addBill();
            }
        });
        add(add_bill);
        list_reserve=new JButton("List reserve");
        list_reserve.setLocation(200,200);
        list_reserve.setSize(300,30);
        list_reserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctor_main.showListReserve();
            }
        });
        add(list_reserve);

    }
}
