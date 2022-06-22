import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctorpart extends Container {
    public JButton add_doctor;
    public JButton view_doctor;
    public JButton delete_doctor;
    public JButton exit;

    public Doctorpart() {
        setSize(700, 700);
        setLayout(null);
        add_doctor = new JButton("Add doctor");
        add_doctor.setLocation(200, 150);
        add_doctor.setSize(300, 30);
        add_doctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddDoctor();
            }
        });
        add(add_doctor);
        view_doctor = new JButton("View doctor");
        view_doctor.setLocation(200, 200);
        view_doctor.setSize(300, 30);
        view_doctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showDoctorPage();
            }
        });
        add(view_doctor);
        delete_doctor= new JButton("Delete doctor");
        delete_doctor.setLocation(200, 250);
        delete_doctor.setSize(300, 30);

        delete_doctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDelete_doc();
            }
        });
        add(delete_doctor);
        exit = new JButton("Exit");
        exit.setBounds(200, 300, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(exit);
    }
}
