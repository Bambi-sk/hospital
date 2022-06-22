import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public AdminAddDepartment addDepartment;
    public AdminAddDoctor addDoctor;
    public AdminAddService addService;
    public AdminDeleteDepart deleteDepart;
    public AdminDeleteDoctor deleteDoctor;
    public AdminDeleteService deleteService;
    public AdminViewDepart viewDepart;
    public AdminViewDoctor viewDoctor;
    public AdminViewService viewService;
    public AdminMainMenu menu;
    public Doctorpart doctorpart;
    public ResPart resPart;
    public DepartPart departPart;
    public ServicePart servicePart;
    public AdminLogin login;
    public AdminAddRes addRes;
    public AdminDeleteRes deleteRes;
    public AdminViewRes viewRes;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);


        login=new AdminLogin();
        login.setLocation(0,0);
        login.setVisible(true);
        add(login);

        doctorpart=new Doctorpart();
        doctorpart.setLocation(0,0);
        doctorpart.setVisible(false);
        add(doctorpart);

        resPart=new ResPart();
        resPart.setLocation(0,0);
        resPart.setVisible(false);
        add(resPart);

        departPart=new DepartPart();
        departPart.setLocation(0,0);
        departPart.setVisible(false);
        add(departPart);

        servicePart=new ServicePart();
        servicePart.setLocation(0,0);
        servicePart.setVisible(false);
        add(servicePart);


        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);
        addService = new AdminAddService();
        addService.setLocation(0,0);
        addService.setVisible(false);
        add(addService);
        addDoctor=new AdminAddDoctor();
        addDoctor.setLocation(0,0);
        addDoctor.setVisible(false);
        add(addDoctor);
        addDepartment=new AdminAddDepartment();
        addDepartment.setLocation(0,0);
        addDepartment.setVisible(false);
        add(addDepartment);
        deleteService=new AdminDeleteService();
        deleteService.setLocation(0,0);
        deleteService.setVisible(false);
        add(deleteService);
        deleteDoctor=new AdminDeleteDoctor();
        deleteDoctor.setLocation(0,0);
        deleteDoctor.setVisible(false);
        add(deleteDoctor);
        deleteDepart=new AdminDeleteDepart();
        deleteDepart.setLocation(0,0);
        deleteDepart.setVisible(false);
        add(deleteDepart);
        viewDoctor=new AdminViewDoctor();
        viewDoctor.setLocation(0,0);
        viewDoctor.setVisible(false);
        add(viewDoctor);

        viewService=new AdminViewService();
        viewService.setLocation(0,0);
        viewService.setVisible(false);
        add(viewService);
        viewDepart=new AdminViewDepart();
        viewDepart.setLocation(0,0);
        viewDepart.setVisible(false);
        add(viewDepart);
        viewRes=new AdminViewRes();
        viewRes.setLocation(0,0);
        viewRes.setVisible(false);
        add(viewRes);
        addRes=new AdminAddRes();
        addRes.setLocation(0,0);
        addRes.setVisible(false);
        add(addRes);
        deleteRes=new AdminDeleteRes();
        deleteRes.setLocation(0,0);
        deleteRes.setVisible(false);
        add(deleteRes);






        repaint();
    }

}
