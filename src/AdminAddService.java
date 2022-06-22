import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminAddService extends Container {

    private JLabel label_price;
    private JTextField text_price;
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_idDoctor;
    private JTextField text_idDoctor;
    private JButton addService;
    private JButton back;
    private JTextArea area;
    private JTable table;
    private JComboBox comboBoxDEP;
    private JComboBox comboBoxDOC;
    private JButton upload;

    public AdminAddService() {
            setLayout(null);
            setSize(700, 780);

            label_name = new JLabel("Name:");
            label_name.setBounds(250, 70, 80, 40);
            add(label_name);
            text_name= new JTextField();
            text_name.setBounds(340, 70, 100, 40);
            add(text_name);

            label_price = new JLabel("Price:");

            label_price.setBounds(250, 120, 80, 40);
            add(label_price);

            text_price= new JTextField();
            text_price.setBounds(340, 120, 100, 40);
            add(text_price);

            label_idDoctor = new JLabel("Department name:");
            label_idDoctor.setBounds(250, 170, 80, 40);
            add(label_idDoctor);

//            text_idDoctor = new JTextField();
//            text_idDoctor.setBounds(340, 170, 100, 40);
//            add(text_idDoctor);
            comboBoxDEP=new JComboBox();
            comboBoxDEP.setBounds(340, 170, 100, 40);
            ArrayList<department> list=new ArrayList<>();
            list=Admin.listdep();
            String dep_name[]=new String[list.size()];
            for(int i=0;i<list.size();i++){

                comboBoxDEP.addItem(list.get(i).getName());
            }

            add(comboBoxDEP);
            upload=new JButton("upload doctor");
            upload.setBounds(450,170,100,40);

            upload.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Doctor> list_doctor = new ArrayList<>();
                    list_doctor = Admin.listDoctor();
                    ArrayList<Doctor> list_need= new ArrayList<>();

                    for (int i = 0; i < list_doctor.size(); i++) {
                        if (comboBoxDEP.getSelectedItem().equals(list_doctor.get(i).getId_department())) {
                            String columnNames[] =new String[]{"ID","name","spes"};
                            list_need.add(list_doctor.get(i));
                            comboBoxDOC=new JComboBox();
                            comboBoxDOC.setBounds(250, 230, 100, 40);
                            ArrayList<department> list=new ArrayList<>();
                            list=Admin.listdep();
                            String dep_name[]=new String[list.size()];
                            for(int j=0;j<list_need.size();j++){

                                comboBoxDOC.addItem(list_need.get(j).getName());
                            }
                            add(comboBoxDOC);

//                            String data[][] = new String[list_need.size()][3];
//
//                            int k = 0;
//                            for(Doctor st : list_need){
//                                data[k][0] = String.valueOf(st.getId_staff());
//                                data[k][1]=st.getName();
//                                data[k][2] = st.getSpes();
//                                k++;
//                            }
//
//                            table = new JTable(data, columnNames);
//                            table.setBounds(500,500,500,500);
//
//                            add(table);
                            repaint();


                        }
                    }
                }

            });
        add(upload);


            addService = new JButton("Add");
            addService.setBounds(250, 300, 100, 50);
            addService.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double price = 0;
                    Long id;
                     Long id_doctor;

                    try {
                        price = Double.parseDouble(text_price.getText());
//                        id=Long.parseLong(text_idDoctor.getText());

                        ArrayList<Doctor> list1=new ArrayList<>();
                        list1=Admin.listDoctor();
                        for(int i=0;i<list1.size();i++){
                            if(comboBoxDOC.getSelectedItem().toString().equals(list1.get(i).getName())){
                                id_doctor=list1.get(i).getId_staff();
                                Service service = new Service(null, text_name.getText(), price,id_doctor,comboBoxDEP.getSelectedItem().toString());
                                Admin.addService(service);
                            }
                        }




                        text_price.setText("");
//                        text_idDoctor.setText("");
                        text_name.setText("");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            add(addService);

            back = new JButton("Back");
            back.setBounds(340, 300, 100, 50);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Admin.showServicepart();
                }
            });
            add(back);
//        area = new JTextArea();
//        area.setSize(600,400);
//        area.setLocation(250,200);
//        add(area);

    }


    }

