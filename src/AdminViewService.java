import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminViewService extends Container {
    private JLabel label;
    private JButton button;
    private JTextArea area;
    private JTable table;
    public AdminViewService() {
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
                Admin.showServicepart();
            }
        });
        add(button);

//        area = new JTextArea();
//        area.setSize(600,400);
//        area.setLocation(50,50);
//        add(area);
    }
//    public void updateArea(ArrayList<Service> services){
//        area.setText("");
//        for(Service ts: services){
//            area.append(ts+"\n");
//        }
//        repaint();
//    }

    public void updateArea(ArrayList<Service> services){

        String columnNames[] =new String[]{"ID", "name", "price","id_doctor"};

        String data[][] = new String[services.size()][4];

        int i = 0;
        for(Service st : services){
            data[i][0] = String.valueOf(st.getId_service());
            data[i][1] = st.getName();
            data[i][2]=String.valueOf(st.getPrice());
            data[i][3]= String.valueOf(st.getId_doctor());


            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,480,300);

        add(table);
        repaint();
    }
}
