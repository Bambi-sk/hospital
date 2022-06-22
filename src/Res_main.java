import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Res_main {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static ResMainFrame frame;
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
    public static ArrayList<Res> listRes(){
        ArrayList<Res> res =new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_res");
        pd.setResArrayList(res);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                res=pd.getResArrayList();
            }
        }catch (Exception e){e.printStackTrace();}
        return res;
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
    public static ArrayList<department> listdep(){
        ArrayList<department> departments =new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_department");
        pd.setDepartments(departments);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                departments=pd.getDepartments();
            }
        }catch (Exception e){e.printStackTrace();}
        return departments;
    }
    public static void showMenu(){
       Res_main.frame.resMainMenu.setVisible(true);
       Res_main.frame.addRecorrd.setVisible(false);
       Res_main.frame.resAddPatient.setVisible(false);
       Res_main.frame.resLogin.setVisible(false);

       Res_main.frame.repaint();
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
    public static void addPatient(Patient patient){
        PackageData pd=new PackageData();
        pd.setCode("add_patient");
        pd.setPatient(patient);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addRecord(Record record){
        PackageData pd=new PackageData();
        pd.setCode("add_record");
        pd.setRecord(record);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void showAddPatient(){
        Res_main.frame.resMainMenu.setVisible(false);
        Res_main.frame.addRecorrd.setVisible(false);
        Res_main.frame.resAddPatient.setVisible(true);
        Res_main.frame.resLogin.setVisible(false);

        Res_main.frame.repaint();
    }
    public static void showAddRecord(){
        Res_main.frame.resMainMenu.setVisible(false);
        Res_main.frame.addRecorrd.setVisible(true);
        Res_main.frame.resAddPatient.setVisible(false);
        Res_main.frame.resLogin.setVisible(false);

        Res_main.frame.repaint();
    }

    public static void main(String[] args){
        connectToServer();

        frame = new ResMainFrame();
        frame.setVisible(true);
    }

}
