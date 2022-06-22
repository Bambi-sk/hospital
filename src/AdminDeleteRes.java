import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeleteRes extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton delete;
    private JButton back;

    public AdminDeleteRes() {

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

                Admin.deleteWithIdRes(id);

                Admin.showRespart();
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
            Admin.showRespart();
        }
    });
    add(back);

}


    public void updateArea(ArrayList<Res> res){

        String columnNames[] =new String[]{"ID", "login", "password"};

        String data[][] = new String[res.size()][6];

        int i = 0;
        for(Res st : res){
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getLogin();
            data[i][2]=st.getPassword();

            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,300,300);

        add(table);
        repaint();
    }
}
