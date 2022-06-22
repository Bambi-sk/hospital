import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddRes extends Container {
    private JLabel label_login;
    private JTextField text_login;
    private JLabel label_password;
    private JTextField text_password;
    private JButton addRes;
    private JButton back;

    public AdminAddRes() {
        setLayout(null);
        setSize(700, 700);

        label_login = new JLabel("Login:");
        label_login.setBounds(250, 150, 80, 40);
        add(label_login);
        text_login= new JTextField();
        text_login.setBounds(340, 150, 100, 40);
        add(text_login);

        label_password = new JLabel("Password:");

        label_password.setBounds(250, 300, 80, 40);
        add(label_password);

        text_password = new JTextField();
        text_password.setBounds(340, 300, 100, 40);
        add(text_password);
        addRes = new JButton("Add");
        addRes.setBounds(250, 500, 100, 50);
        addRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Res  res= new Res(null, text_login.getText(), text_password.getText());

                    Admin.addRes(res);
                    System.out.println("yes show");

                    text_login.setText("");
                    text_password.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addRes);

        back = new JButton("Back");
        back.setBounds(360, 500, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showRespart();
            }
        });
        add(back);

    }
}
