import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminViewDoctor extends Container {
    private JLabel label;
    private JTable table;
    private JButton button;
    private JTextArea area;

    public AdminViewDoctor(){
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
                Admin.showDoctorpart();
            }
        });
        add(button);

//        area = new JTextArea();
//        area.setSize(600,400);
//        area.setLocation(50,50);
//        add(area);
    }

    public void updateArea(ArrayList<Doctor> doctors){

        String columnNames[] =new String[]{"ID", "login", "password","name","surname","spes"};

        String data[][] = new String[doctors.size()][6];

        int i = 0;
        for(Doctor st : doctors){
            data[i][0] = String.valueOf(st.getId_staff());
            data[i][1] = st.getLogin();
            data[i][2]=st.getPassword();
            data[i][3]=st.getName();
            data[i][4]=st.getSurname();
            data[i][5] = st.getSpes();

            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,440,300);

        add(table);
        repaint();
    }
}
