import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddDepartment extends Container {
    //    private JLabel label_id;
//    private JTextField text_id;
    private JTable table;
    private JLabel label_name;
    private JTextField text_name;
    private JTextArea area;
    private JButton addDep;
    private JButton back;

    public AdminAddDepartment() {
        setLayout(null);
        setSize(700, 750);

        label_name = new JLabel("Name:");
        label_name.setBounds(250, 100, 80, 40);
        add(label_name);
        text_name = new JTextField();
        text_name.setBounds(340, 100, 100, 40);
        add(text_name);

        addDep = new JButton("Add");
        addDep.setBounds(250, 170, 100, 50);
        addDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                Long id_d;

                try {
                    department dep = new department(null, text_name.getText());
                    Admin.addDep(dep);
                    text_name.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addDep);

        back = new JButton("Back");
        back.setBounds(360, 170, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showDepartpart();
            }
        });
        add(back);
//        area = new JTextArea();
//        area.setSize(600,400);
//        area.setLocation(250,200);
//        add(area);
    }
}

