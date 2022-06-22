import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResPart extends Container {
    public JButton add_res;
    public JButton view_res;
    public JButton delete_res;
    public JButton exit;


    public ResPart() {
        setLayout(null);
        setSize(700,700);
        add_res = new JButton("Add Res");
        add_res.setLocation(200, 150);
        add_res.setSize(300, 30);
        add_res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddRes();
            }
        });
        add(add_res);
        view_res= new JButton("View res");
        view_res.setLocation(200, 200);
        view_res.setSize(300, 30);
        view_res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showViewRes();
            }
        });
        add(view_res);

        delete_res= new JButton("Delete res");
        delete_res.setLocation(200, 250);
        delete_res.setSize(300, 30);

        delete_res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDelRes();
            }
        });
        add(delete_res);
        exit = new JButton("Back");
        exit.setBounds(200, 300, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(exit);


    }
}
