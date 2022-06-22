import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Doctor_main {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static DoctorMainFrame frame;
    public static Socket socket;
    public static Long current_id;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",5999);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Doctor> listDoctor(){
        ArrayList<Doctor> doctors =new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_doctor");
        pd.setDoctors(doctors);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                doctors=pd.getDoctors();
            }
        }catch (Exception e){e.printStackTrace();}
        return doctors;
    }
    public static void edit(Long id,String bill_name,String bill_description){
        PackageData pd=new PackageData();
        pd.setCode("edit_record");
        pd.setId(id);
        pd.setBill_name(bill_name);
        pd.setBill_description(bill_description);
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<Patient> listPatient(){
        ArrayList<Patient> list=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_patient");
        pd.setPatients(list);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                list=pd.getPatients();
                for(int i=0;i<list.size();i++){
                    System.out.println("bb");
                    System.out.println(list.get(i));
                }
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
    public static ArrayList<Bill> listBill(){
        ArrayList<Bill> list=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_bill");
        pd.setBills(list);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                list=pd.getBills();
                for(int i=0;i<list.size();i++){
                    System.out.println("bb");
                    System.out.println(list.get(i));
                }
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
    public static ArrayList<Record> listRecord(){
        ArrayList<Record> list=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_record");
        pd.setRecords(list);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                list=pd.getRecords();
                for(int i=0;i<list.size();i++){
                    System.out.println("bb");
                    System.out.println(list.get(i));
                }
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
    public static void addBill(Bill bill){
        PackageData pd=new PackageData();
        pd.setCode("add_bill");
        pd.setBill(bill);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addPatient(Patient patient){
        PackageData pd=new PackageData();
        pd.setCode("add_patient");
        pd.setPatient(patient);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void editPatient(Long id_patient,Long id_service,Long id_bill){
        PackageData pd=new PackageData();
        pd.setCode("edit_patient");
        pd.setId(id_patient);
        pd.setId_bills(id_bill);
        pd.setId_service(id_service);
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void showPatient(){
        Doctor_main.frame.viewPatient.setVisible(true);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(false);
        Doctor_main.frame.menu.setVisible(false);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(false);
        Doctor_main.frame.doctorAddBill.setVisible(false);

        Doctor_main.frame.repaint();
    }
    public static void showListReserve(){
        Doctor_main.frame.viewPatient.setVisible(false);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(false);
        Doctor_main.frame.menu.setVisible(false);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(true);
        Doctor_main.frame.doctorAddBill.setVisible(false);
        ArrayList<Bill> bills=listBill();
        ArrayList<Patient> patients=new ArrayList<>();
        patients=listPatient();
        ArrayList<Service> services=new ArrayList<>();
        services=listService();
        ArrayList<Record> records=new ArrayList<>();
        records=Doctor_main.listRecord();
        ArrayList<Doctor> doctors=new ArrayList<>();
        doctors=Doctor_main.listDoctor();
        Doctor_main.frame.reserveList.updateArea(records,patients,doctors);

        Doctor_main.frame.repaint();
    }
    public static ArrayList<Service> listService(){
        ArrayList<Service> services =new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_service");
        pd.setServices(services);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                services=pd.getServices();
            }
        }catch (Exception e){e.printStackTrace();}
        return services;
    }
    public static void addPatient(){
        Doctor_main.frame.viewPatient.setVisible(false);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(true);
        Doctor_main.frame.menu.setVisible(false);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(false);
        Doctor_main.frame.doctorAddBill.setVisible(false);

        Doctor_main.frame.repaint();
    }
    public static void addBill(){
        Doctor_main.frame.viewPatient.setVisible(false);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(false);
        Doctor_main.frame.menu.setVisible(false);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(false);
        Doctor_main.frame.doctorAddBill.setVisible(true);

        Doctor_main.frame.repaint();
    }
    public static void editPatient(){
        Doctor_main.frame.viewPatient.setVisible(false);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(false);
        Doctor_main.frame.menu.setVisible(false);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(true);
        ArrayList<Bill> bills=listBill();
        ArrayList<Patient> patients=new ArrayList<>();
        patients=listPatient();
        ArrayList<Service> services=new ArrayList<>();
        services=listService();
        ArrayList<Record> records=new ArrayList<>();
        records=Doctor_main.listRecord();
        ArrayList<Doctor> doctors=new ArrayList<>();
        doctors=Doctor_main.listDoctor();

        Doctor_main.frame.reserveList.updateArea(records,patients,doctors);
        Doctor_main.frame.doctorAddBill.setVisible(false);

        Doctor_main.frame.repaint();
    }
    public static void showMenu(){
        Doctor_main.frame.viewPatient.setVisible(false);
        Doctor_main.frame.editPatient.setVisible(false);
        Doctor_main.frame.addPatient.setVisible(false);
        Doctor_main.frame.menu.setVisible(true);
        Doctor_main.frame.doctorLogin.setVisible(false);
        Doctor_main.frame.reserveList.setVisible(false);
        Doctor_main.frame.doctorAddBill.setVisible(false);

        Doctor_main.frame.repaint();
    }
    public static void addDoctor_current(Long id) {
        current_id=id;
    }



    public static void main(String[] args){
        connectToServer();
        frame = new DoctorMainFrame();
        frame.setVisible(true);
    }

}
