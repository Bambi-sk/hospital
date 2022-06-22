import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorViewPatient extends Container {
    private JTable table;
    private JLabel label;
    private JButton button;

    public DoctorViewPatient() {
        setLayout(null);
        setSize(700,700);

        label=new JLabel("VIEW ");
        label.setBounds(320,10,150,60);
        add(label);

        button = new JButton("Back");
        button.setLocation(210,600);
        button.setSize(300,30);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(button);
    }

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
        table.setBounds(50,50,200,500);

        add(table);
        repaint();
    }
}
