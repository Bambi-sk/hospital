import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorEditPatient extends Container {
    private JLabel label_id_patient;
    private JTextField text_id_patient;
    private JLabel label_bill_id;
    private JTextField text_bill_id;
    private JLabel label_service_id;
    private JTextField text_service_id;

    public DoctorEditPatient() {
        setLayout(null);
        setSize(700, 700);
        label_id_patient= new JLabel("Patient:");
        label_id_patient.setBounds(250, 100, 80, 40);
        add(label_id_patient);
        text_id_patient = new JTextField();
        text_id_patient.setBounds(340, 100, 100, 40);
        add(text_id_patient);

        label_bill_id = new JLabel("Bill_id:");
        label_bill_id.setBounds(250, 150, 80, 40);
        add(label_bill_id);

        text_bill_id = new JTextField();
        text_bill_id.setBounds(340, 150, 100, 40);
        add(text_bill_id);


        label_service_id = new JLabel("Surname:");
        label_service_id.setBounds(250,200 , 80, 40);
        add(label_service_id);

        text_service_id= new JTextField();
        text_service_id.setBounds(340, 200, 100, 40);
        add(text_service_id);


        EditPatient = new JButton("Edit");
        EditPatient.setBounds(250, 250, 100, 50);

        EditPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                Long id2;
                Long id3;
                try{
                    id=Long.parseLong(text_id_patient.getText());
                    id2=Long.parseLong(text_bill_id.getText());
                    id3=Long.parseLong(text_service_id.getText());
                    Doctor_main.editPatient(id,id2,id3);

                    Doctor_main.showMenu();
                    text_id_patient.setText("");
                    text_bill_id.setText("");
                    text_service_id.setText("");

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(EditPatient);

        back=new JButton("BACK");
        back.setBounds(450,500,100,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor_main.showMenu();
            }
        });
        add(back);

    }

    private JButton EditPatient;
    private JButton back;
    private JTable table;
    public void updateArea_patient(ArrayList<Patient> patients){

        String columnNames[] =new String[]{"ID","name"};

        String data[][] = new String[patients.size()][2];

        int i = 0;
        for( Patient st : patients){
            data[i][0] = String.valueOf(st.getId_patient());
            data[i][1] = st.getName();


            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(50,300,200,500);

        add(table);
        repaint();
    }
    private JTable table1;
    public void updateArea_Bill(ArrayList<Bill> Bill){

        String columnNames[] =new String[]{"ID","name"};

        String data[][] = new String[Bill.size()][2];

        int i = 0;
        for( Bill st : Bill){
            data[i][0] = String.valueOf(st.getId_bill());
            data[i][1] = st.getName();


            i++;
        }

        table1 = new JTable(data, columnNames);
        table1.setBounds(250,300,200,500);

        add(table1);
        repaint();
    }
    private JTable table2;
    public void updateArea_Service(ArrayList<Service> Service){

        String columnNames[] =new String[]{"ID","name"};

        String data[][] = new String[Service.size()][2];

        int i = 0;
        for( Service st : Service){
            data[i][0] = String.valueOf(st.getId_service());
            data[i][1] = st.getName();


            i++;
        }

        table2 = new JTable(data, columnNames);
        table2.setBounds(450,300,200,500);

        add(table2);
        repaint();
    }
}
