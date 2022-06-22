import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResMainMenu extends Container {
    public JButton addRecord;
    public JButton addPatient;
    public JButton exit;
    public ResMainMenu() {
        setLayout(null);
        setSize(700,700);

        addRecord= new JButton("add Record");
        addRecord.setLocation(200, 150);
        addRecord.setSize(300, 30);
        addRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Res_main.showAddRecord();
            }
        });
        add(addRecord);

        addPatient= new JButton("add Patient");
        addPatient.setLocation(200, 200);
        addPatient.setSize(300, 30);
        addPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Res_main.showAddPatient();
            }
        });
        add(addPatient);

        exit = new JButton("Exit");
        exit.setBounds(200, 250, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
