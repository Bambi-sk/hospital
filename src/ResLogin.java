import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResLogin extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton signIn;
    private JLabel welcome;


    public ResLogin () {
        setLayout(null);
        setSize(700, 700);

        login = new JLabel("Login:");
        login.setBounds(250, 150, 80, 40);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        password = new JLabel("Password:");
        password.setBounds(250, 200, 80, 40);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);
        welcome = new JLabel("");
        welcome.setBounds(250, 400, 80, 40);
        add(welcome);



        signIn=new JButton("Sign_in");
        signIn.setBounds(340,250,100,50);
        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Res> res = Res_main.listRes();
                System.out.println("");
                for (int i = 0; i < res.size(); i++) {
                    if (res.get(i).getLogin().equals(textLogin.getText()) && res.get(i).getPassword().equals(textpassword.getText())) {
                            Res_main.showMenu();
                        break;
                    } else {
                        welcome.setText("Wrong password or login");
                    }



                }

            }

        });
        add(signIn);
        repaint();


    }
}
