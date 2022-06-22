import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeleteDepart extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton delete;
    private JButton back;

    public AdminDeleteDepart(){
        setLayout(null);
        setSize(700,700);

        label=new JLabel("INSERT ID:");
        label.setBounds(250,450,80,30);
        add(label);

        textField=new JTextField("");
        textField.setBounds(340,450,100,30);
        add(textField);

        delete=new JButton("DELETE");
        delete.setBounds(150,500,100,50);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try{
                    id=Long.parseLong(textField.getText());

                    Admin.deleteWithIdDep(id);

                    Admin.showMenuPage();
                    textField.setText("");

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back=new JButton("BACK");
        back.setBounds(450,500,100,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showDepartpart();
            }
        });
        add(back);

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
        table.setBounds(70,80,200,200);

        add(table);
        repaint();
    }
}
