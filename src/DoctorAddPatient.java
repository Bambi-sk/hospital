import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorAddPatient extends Container {
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_surname;
    private JTextField text_surname;
    private JLabel label_bill_id;
    private JTextField text_bill_id;
    private JLabel label_service_id;
    private JTextField text_service_id;


    private JButton addPatient;
    private JButton back;

    public DoctorAddPatient() {
        setLayout(null);
        setSize(700, 700);

        label_name = new JLabel("Name:");
        label_name.setBounds(250, 50, 80, 40);
        add(label_name);
        text_name =new JTextField();
        text_name.setBounds(340, 50, 100, 40);
        add(text_name);

        label_surname = new JLabel("Surname:");

        label_surname.setBounds(250, 100, 80, 40);
        add(label_surname);

        text_surname = new JTextField();
        text_surname.setBounds(340, 100, 100, 40);
        add(text_surname);

//        label_bill_id = new JLabel("Bill_id:");
//        label_bill_id.setBounds(250, 150, 80, 40);
//        add(label_bill_id);
//
//        text_bill_id = new JTextField();
//        text_bill_id.setBounds(340, 150, 100, 40);
//        add(text_bill_id);
//
//
//        label_service_id = new JLabel("Surname:");
//        label_service_id.setBounds(250,200 , 80, 40);
//        add(label_service_id);
//
//        text_service_id= new JTextField();
//        text_service_id.setBounds(340, 200, 100, 40);
//        add(text_service_id);


        addPatient = new JButton("Add");
        addPatient.setBounds(250, 250, 100, 50);
        addPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    Patient patient=new Patient(null,text_name.getText(),text_surname.getText());
                    Doctor_main.addPatient(patient);

                    text_name.setText("");
                    text_surname.setText("");
//

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addPatient);

        back = new JButton("Back");
        back.setBounds(360, 250, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor_main.frame.viewPatient.setVisible(false);
                Doctor_main.frame.editPatient.setVisible(false);
                Doctor_main.frame.addPatient.setVisible(false);
                Doctor_main.frame.menu.setVisible(true);
                Doctor_main.frame.doctorLogin.setVisible(false);
            }
        });
        add(back);
    }
}
