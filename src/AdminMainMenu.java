import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends Container {

    public JButton res;
    public JButton doctor;
    public JButton depart;
    public JButton service;
    public JButton exit;
    public AdminMainMenu() {
        setLayout(null);
        setSize(700,700);

        doctor = new JButton("doctor part");
        doctor.setLocation(200, 150);
        doctor.setSize(300, 30);
        doctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showDoctorpart();
            }
        });
        add(doctor);

        service = new JButton("service part");
        service.setLocation(200, 200);
        service.setSize(300, 30);
        service.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showServicepart();
            }
        });
        add(service);

        depart = new JButton("department part");
        depart.setLocation(200, 250);
        depart.setSize(300, 30);
        depart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showDepartpart();
            }
        });
        add(depart);

        res = new JButton("res part");
        res.setLocation(200, 300);
        res.setSize(300, 30);
        res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showRespart();
            }
        });
        add(res);


        exit = new JButton("Exit");
        exit.setBounds(200, 350, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
        repaint();

    }
}
