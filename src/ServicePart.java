import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicePart extends Container {
    public JButton add_service;
    public JButton view_service;
    public JButton delete_service;
    public JButton exit;

    public ServicePart() {
        setLayout(null);
        setSize(700,700);
        add_service = new JButton("Add service");
        add_service.setLocation(200, 230);
        add_service.setSize(300, 30);
        add_service.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddService();
            }
        });
        add(add_service);


        view_service = new JButton("View service");
        view_service.setLocation(200, 280);
        view_service.setSize(300, 30);
        view_service.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showServicePage();
            }
        });
        add(view_service);


        delete_service= new JButton("Delete service");
        delete_service.setLocation(200, 380);
        delete_service.setSize(300, 30);

        delete_service.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeleteService();
            }
        });
        add(delete_service);
        exit = new JButton("Exit");
        exit.setBounds(200, 430, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(exit);

    }
}
