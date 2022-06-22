import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResAddPatient extends Container {
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_surname;
    private JTextField text_surname;
    private JButton addPatient;
    private JButton back;
    public ResAddPatient() {
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
        addPatient = new JButton("Add");
        addPatient.setBounds(250, 250, 100, 50);
        addPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Patient patient=new Patient(null,text_name.getText(),text_surname.getText());
                    Res_main.addPatient(patient);

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
               Res_main.showMenu();
            }
        });
        add(back);
    }
}
