import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminAddDoctor extends Container {
    private JLabel label_login;
    private JTextField text_login;
    private JLabel label_password;
    private JTextField text_password;
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_surname;
    private JTextField text_surname;
    private JLabel label_spes;
    private JComboBox text_spes;
    private JLabel label_dep;
    private JTextField text_dep;
    private JComboBox comboBoxDEP;
    private JButton addDoctor;
    private JButton back;

    public AdminAddDoctor() {
        setLayout(null);
        setSize(700, 700);

        label_login = new JLabel("Login:");
        label_login.setBounds(250, 150, 80, 40);
        add(label_login);
        text_login= new JTextField();
        text_login.setBounds(340, 150, 100, 40);
        add(text_login);

        label_password = new JLabel("Password:");

        label_password.setBounds(250, 300, 80, 40);
        add(label_password);

        text_password = new JTextField();
        text_password.setBounds(340, 300, 100, 40);
        add(text_password);

        label_name = new JLabel("Name:");
        label_name.setBounds(250, 350, 80, 40);
        add(label_name);

        text_name = new JTextField();
        text_name.setBounds(340, 350, 100, 40);
        add(text_name);


        label_surname = new JLabel("Surname:");
        label_surname.setBounds(250, 400, 80, 40);
        add(label_surname);

        text_surname = new JTextField();
        text_surname.setBounds(340, 400, 100, 40);
        add(text_surname);

        label_spes = new JLabel("Spes:");
        label_spes.setBounds(250, 450, 80, 40);
        add(label_spes);

        text_spes = new JComboBox();
        text_spes.setBounds(340, 450, 100, 40);
        text_spes.addItem("therapist");
        text_spes.addItem("otolaryngologist");
        text_spes.addItem("oculist");
        text_spes.addItem("surgeon");
        text_spes.addItem("endocrinologist");
        text_spes.addItem("neuropathologist");
        text_spes.addItem("dentist");
        text_spes.addItem("allergist");
        text_spes.addItem("dermatologist");
        add(text_spes);
        comboBoxDEP=new JComboBox();
        comboBoxDEP.setBounds(500,450,100,40);
        ArrayList<department> list=new ArrayList<>();
        list=Admin.listdep();
        System.out.println(list);
        String dep_name[]=new String[list.size()];
        for(int i=0;i<list.size();i++){
            dep_name[i]=list.get(i).getName();
            comboBoxDEP.addItem(list.get(i).getName());
        }
//        comboBoxDEP.addItem(dep_name);
        add(comboBoxDEP);


        addDoctor = new JButton("Add");
        addDoctor.setBounds(250, 500, 100, 50);
        addDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Doctor doctor=new Doctor(null,text_login.getText(),text_password.getText(),text_name.getText(),text_surname.getText(),text_spes.getSelectedItem().toString(),comboBoxDEP.getSelectedItem().toString());
                    Admin.addDoctor(doctor);
                    text_login.setText("");
                    text_password.setText("");
                    text_name.setText("");
                    text_surname.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addDoctor);

        back = new JButton("Back");
        back.setBounds(360, 500, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Admin.showDoctorpart();
            }
        });
        add(back);
    }
}
