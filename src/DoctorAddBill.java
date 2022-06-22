import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorAddBill extends Container {

    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_des;
    private JTextField text_des;
    private JButton addBill;
    private JButton back;

    public DoctorAddBill() {
        setLayout(null);
        setSize(700, 780);

        label_name = new JLabel("Name:");
        label_name.setBounds(250, 70, 80, 40);
        add(label_name);
        text_name= new JTextField();
        text_name.setBounds(340, 70, 100, 40);
        add(text_name);

        label_des = new JLabel("Description:");

        label_des.setBounds(250, 120, 80, 40);
        add(label_des);

        text_des= new JTextField();
        text_des.setBounds(340, 120, 100, 40);
        add(text_des);


        addBill = new JButton("Add");
        addBill.setBounds(250, 220, 100, 50);
        addBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Bill bill = new Bill(text_name.getText(), text_des.getText(),null);
                    Doctor_main.addBill(bill);

                    text_name.setText("");
                    text_des.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addBill);

        back = new JButton("Back");
        back.setBounds(360, 220, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor_main.showMenu();
            }
        });
        add(back);
}}

