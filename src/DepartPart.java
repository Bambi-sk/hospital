import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartPart extends Container {
    public JButton add_department;
    public JButton view_department;
    public JButton delete_dep;
    public JButton exit;
    public DepartPart() {
        setLayout(null);
        setSize(700,700);
        add_department = new JButton("Add department");
        add_department.setLocation(200, 190);
        add_department.setSize(300, 30);
        add_department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddDep();
            }
        });
        add(add_department);
        view_department = new JButton("View department");
        view_department.setLocation(200, 350);
        view_department.setSize(300, 30);
        view_department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showDepPage();
            }
        });
        add(view_department);

        delete_dep= new JButton("Delete department");
        delete_dep.setLocation(200, 390);
        delete_dep.setSize(300, 30);

        delete_dep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDelete_dep();
            }
        });
        add(delete_dep);
        exit = new JButton("Exit");
        exit.setBounds(200, 510, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(exit);


    }
}
