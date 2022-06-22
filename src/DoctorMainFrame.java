import javax.swing.*;

public class DoctorMainFrame extends JFrame {
    public DoctorLogin doctorLogin;
    public DoctorAddPatient addPatient;
    public DoctorViewPatient viewPatient;
    public DoctorEditPatient editPatient;
    public DoctorMenuMain menu;
    public DoctorAddBill doctorAddBill;
    public  DoctorReserveList reserveList;
    public DoctorMainFrame(){
        setTitle("Doctor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);



         menu= new DoctorMenuMain();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addPatient=new DoctorAddPatient();
        addPatient.setLocation(0,0);
        addPatient.setVisible(false);
        add(addPatient);

        editPatient=new DoctorEditPatient();
        editPatient.setLocation(0,0);
        editPatient.setVisible(false);
        add(editPatient);

        viewPatient=new DoctorViewPatient();
        viewPatient.setLocation(0,0);
        viewPatient.setVisible(false);
        add(viewPatient);
        reserveList=new DoctorReserveList();
        reserveList.setLocation(0,0);
        reserveList.setVisible(false);
        add(reserveList);

        doctorLogin=new DoctorLogin();
        doctorLogin.setLocation(0,0);
        doctorLogin.setVisible(true);
        add(doctorLogin);

        doctorAddBill=new DoctorAddBill();
        doctorAddBill.setLocation(0,0);
        doctorAddBill.setVisible(false);
        add(doctorAddBill);


        repaint();
    }


}
