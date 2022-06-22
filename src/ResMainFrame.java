import javax.swing.*;

public class ResMainFrame extends JFrame {
    public ResLogin resLogin;
    public ResAddPatient resAddPatient;
    public ResMainMenu resMainMenu;
    public ResAddRecorrd addRecorrd;


    public ResMainFrame()  {
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);

        resLogin=new ResLogin();
        resLogin.setLocation(0,0);
        resLogin.setVisible(true);
        add(resLogin);

        resAddPatient=new ResAddPatient();
        resAddPatient.setLocation(0,0);
        resAddPatient.setVisible(false);
        add(resAddPatient);

        resMainMenu=new ResMainMenu();
        resMainMenu.setLocation(0,0);
        resMainMenu.setVisible(false);
        add(resMainMenu);


        addRecorrd=new ResAddRecorrd();
        addRecorrd.setLocation(0,0);
        addRecorrd.setVisible(false);
        add(addRecorrd);
    }
}
