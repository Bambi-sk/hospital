import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminViewRes extends Container {
    private JLabel label;
    private JButton button;
    private JTextArea area;
    private JTable table;

    public AdminViewRes() {
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
                Admin.showRespart();
            }
        });
        add(button);
    }
    public void updateArea(ArrayList<Res> res){

        String columnNames[] =new String[]{"ID", "login","password" };

        String data[][] = new String[res.size()][3];

        int i = 0;
        for(Res st : res){
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getPassword();
            data[i][2]=st.getPassword();

            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,300,300);

        add(table);
        repaint();
    }
}
