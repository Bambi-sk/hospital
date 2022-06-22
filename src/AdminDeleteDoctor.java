import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeleteDoctor extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton delete;
    private JButton back;
    public AdminDeleteDoctor(){
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

                    Admin.deleteWithIdDoctor(id);

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
                Admin.showDoctorpart();
            }
        });
        add(back);

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
