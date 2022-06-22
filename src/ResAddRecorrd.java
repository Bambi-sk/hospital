import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResAddRecorrd extends Container {
    private JLabel label_patient;
    private JTextField text_price;
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_idDoctor;
    private JTextField text_idDoctor;
    private JButton addRecord;
    private JButton back;
    private JTextArea area;
    private JTable table;
    private JComboBox comboBoxPatient;
    private JComboBox comboBoxDEP;
    private JComboBox comboBoxDOC;
    private JComboBox comboBoxService;
    private JLabel dep_label;

    private JButton upload;
    private JButton getAddRecord;

    public ResAddRecorrd() {
        setLayout(null);
        setSize(500, 500);
        label_name = new JLabel("Patient name:");
        label_name.setBounds(150, 10, 80, 40);
        add(label_name);
        comboBoxPatient=new JComboBox();
        comboBoxPatient.setBounds(150, 60, 100, 40);
        ArrayList<Patient> list=new ArrayList<>();
        list=Res_main.listPatient();
        String patient_name[]=new String[list.size()];
        for(int i=0;i<list.size();i++){

            comboBoxPatient.addItem(list.get(i).getName()+" "+list.get(i).getSurname());
        }
        add(comboBoxPatient);
        dep_label=new JLabel("Department name");
        dep_label.setBounds(300,10,80,40);
        add(dep_label);
        comboBoxDEP=new JComboBox();
        comboBoxDEP.setBounds(300, 60, 100, 40);
        ArrayList<department> list_dep=new ArrayList<>();
        list_dep=Res_main.listdep();
        for(int i=0;i<list_dep.size();i++){

            comboBoxDEP.addItem(list_dep.get(i).getName());
        }
        add(comboBoxDEP);
        upload=new JButton("upload service");
        upload.setBounds(180,110,100,50);
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Service> list_service = new ArrayList<>();
                list_service = Res_main.listService();
                ArrayList<Service> list_need_service= new ArrayList<>();

                for (int i = 0; i < list_service.size(); i++) {
                    if (comboBoxDEP.getSelectedItem().equals(list_service.get(i).getName_department())) {
                        list_need_service.add(list_service.get(i));
                        comboBoxService=new JComboBox();
                        comboBoxService.setBounds(180, 170, 100, 40);
                        ArrayList<Doctor> list_doc=new ArrayList<>();
                        list_doc=Res_main.listDoctor();
                        for(int j=0;j<list_need_service.size();j++){

                            comboBoxService.addItem(list_need_service.get(j).getName());
                        }
                        add(comboBoxService);

                        repaint();


                    }
                }
            }

        });
        add(upload);
        getAddRecord = new JButton("Add RECORD");
        getAddRecord.setBounds(150, 250, 100, 50);
        getAddRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = 0;
                Long id;
                String id_doctor;

                try {
                    ArrayList<Patient> list_patient=new ArrayList<>();
                    list_patient=Res_main.listPatient();
                    ArrayList<Doctor> list1=new ArrayList<>();
                    list1=Res_main.listDoctor();
                    ArrayList<Service> list_ser=new ArrayList<>();
                    list_ser=Res_main.listService();
                    for(int i=0;i<list_ser.size();i++){
                        if(comboBoxService.getSelectedItem().toString().equals(list_ser.get(i).getName())){
                            for(int j=0;j<list1.size();j++){
                                if(list_ser.get(i).getId_doctor().equals(list1.get(j).getId_staff())){
                                    id_doctor=list1.get(j).getName();
                                    Record record=new Record(null,id_doctor,comboBoxPatient.getSelectedItem().toString(),comboBoxService.getSelectedItem().toString(),"nothing","nothing");
                                    Res_main.addRecord(record);
                                }
                            }

                        }
                    }



                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(getAddRecord);

        back = new JButton("Back");
        back.setBounds(250, 250, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Res_main.showMenu();
            }
        });
        add(back);





    }
}
