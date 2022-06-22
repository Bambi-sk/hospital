import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorReserveList extends Container {
    public JTable table;
    public JTable table_bill;
    public JButton back;
    public JButton edit;
    private JLabel label_id_patient;
    private JTextField text_id_patient;
    private JLabel label_id_bill;
    private JTextField text_id_bill;
    private JLabel label_description;
    private JTextField text_description;
    public DoctorReserveList() {
        setLayout(null);
        setSize(700, 780);

        label_id_patient = new JLabel("ID RECORD:");
        label_id_patient.setBounds(10, 10, 80, 40);
        add(label_id_patient);
        text_id_patient = new JTextField();
        text_id_patient.setBounds(90, 10, 100, 40);
        add(text_id_patient);

        label_id_bill = new JLabel("NAME BILL:");

        label_id_bill.setBounds(10,50 , 80, 40);
        add(label_id_bill);

        text_id_bill = new JTextField();
        text_id_bill.setBounds(90, 50, 80, 40);
        add(text_id_bill);

        label_description=new JLabel("DESCRIPTION BILL:");
        label_description.setBounds(10,100,80,40);
        add(label_description);
         text_description=new JTextField();
         text_description.setBounds(90,100,120,40);
         add(text_description);

        edit = new JButton("EDIT");
        edit.setBounds(50, 230, 100, 40);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id_patient;
                Long id_bill;
                Long id_service;
                try {
                    id_patient=Long.parseLong(text_id_patient.getText());
                    Doctor_main.edit(id_patient,text_id_bill.getText(),text_description.getText());
                    text_id_patient.setText("");
                    text_id_bill.setText("");
                    text_description.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(edit);

        back = new JButton("Back");
        back.setBounds(150, 230, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor_main.showMenu();
            }
        });
        add(back);
    }
    public void updateArea(ArrayList<Record> records,ArrayList<Patient> patients,ArrayList<Doctor> doctors){

        String columnNames[] =new String[]{"ID", "patient name","service name","bill name","bill description"};
        String data[][] = new String[records.size()][5];
        int i = 0;
        for (int j=0;j<records.size();j++){
            for (int k=0;k<doctors.size();k++){
                if( Doctor_main.current_id.equals(doctors.get(k).getId_staff())){
                   if( doctors.get(k).getName().equals(records.get(j).getId_doctor())){
                       System.out.println("fnfn");

                       data[i][0] = String.valueOf(records.get(j).getId_rec());
                       data[i][1]=records.get(j).getId_patient();
                       data[i][2] =records.get(j).getId_service();
                       data[i][3]=records.get(j).getBill_name();
                       data[i][4]=records.get(j).getBill_description();
                       i++;
                       System.out.println(data);

                       }
                   }

                }

            }
        table = new JTable(data, columnNames);
        table.setBounds(250,50,350,250);

        add(table);

        repaint();

        }





    }

