import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminViewDepart extends Container {
    private JLabel label;
    private JTable table;
    private JButton button;
    private JTextArea area;

    public AdminViewDepart(){
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
                Admin.showDepartpart();
            }
        });
        add(button);

//        area = new JTextArea();
//        area.setSize(600,400);
//        area.setLocation(50,50);
//        add(area);
    }

    public void updateArea(ArrayList<department> departments){

        String columnNames[] =new String[]{"ID", "name"};

        String data[][] = new String[departments.size()][2];

        int i = 0;
        for(department st : departments){
            data[i][0] = String.valueOf(st.getId_department());
            data[i][1] = st.getName();
            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,300,300);

        add(table);
        repaint();
    }
}
