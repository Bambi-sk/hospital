import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Admin  {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static AdminMainFrame frame;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",5999);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }
    public static ArrayList<AdminObject> listAdmin(){
        ArrayList<AdminObject> list=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setCode("list_admin");
        pd.setAdmins(list);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                list=pd.getAdmins();
                for(int i=0;i<list.size();i++){
                    System.out.println("bb");
                    System.out.println(list.get(i));
                }
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
    public static void addDoctor(Doctor doctor){
        PackageData pd=new PackageData();
        System.out.println("bb1");
        pd.setCode("add_doctor");
        pd.setDoctor(doctor);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addService(Service service){
        PackageData pd=new PackageData();
        pd.setCode("add_service");
        pd.setService(service);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addRes(Res res){
        PackageData pd=new PackageData();
        pd.setCode("add_res");
        pd.setRes(res);
        System.out.println("yes pd");
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addDep(department department){
        PackageData pd=new PackageData();
        pd.setCode("add_dep");
        pd.setDepartment(department);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
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
    public static void deleteWithIdDep(Long id){
        PackageData pd=new PackageData();
        pd.setCode("delete_dep");
        pd.setId(id);
        ArrayList<department> departments=pd.getDepartments();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void deleteWithIdRes(Long id){
        PackageData pd=new PackageData();
        pd.setCode("delete_res");
        pd.setId(id);
        ArrayList<Res> res=pd.getResArrayList();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void deleteWithIdDoctor(Long id){
        PackageData pd=new PackageData();
        pd.setCode("delete_doctor");
        pd.setId(id);
        ArrayList<Doctor> doctors=pd.getDoctors();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void deleteWithIdService(Long id){
        PackageData pd=new PackageData();
        pd.setCode("delete_service");
        pd.setId(id);
        ArrayList<Service> services=pd.getServices();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddDoctor(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(true);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showAddRes(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(true);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showViewRes(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(true);
        ArrayList<Res> list=new ArrayList<>();
        list=listRes();
        frame.viewRes.updateArea(list);
        Admin.frame.repaint();
    }
    public static void showDelRes(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(true);
        Admin.frame.viewRes.setVisible(false);
        ArrayList<Res> list=new ArrayList<>();
        list=listRes();
        frame.deleteRes.updateArea(list);
        Admin.frame.repaint();
    }



    public static void showDoctorPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(true);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        ArrayList<Doctor> list = listDoctor();
        Admin.frame.viewDoctor.updateArea(list);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showDelete_doc(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(true);
        ArrayList<Doctor> list=listDoctor();
        frame.deleteDoctor.updateArea(list);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);

        Admin.frame.repaint();
    }
    public static void showAddDep(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(true);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);

        Admin.frame.repaint();
    }
    public static void showAddService(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(true);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        ArrayList<Doctor> list = listDoctor();

        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showDeleteService(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(true);
        ArrayList<Service> list=listService();
        frame.deleteService.updateArea(list);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showDoctorpart(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.doctorpart.setVisible(true);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showDepartpart(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(true);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showServicepart(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(true);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showRespart(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(true);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }


    public static void showDelete_dep(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        ArrayList<department> list=listdep();
        frame.deleteDepart.updateArea(list);
        Admin.frame.deleteDepart.setVisible(true);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
        Admin.frame.menu.setVisible(true);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.departPart.setVisible(false);
//        Admin.frame.repaint();

    }
    public static void showDepPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(true);
        ArrayList<department> list = listdep();
        Admin.frame.viewDepart.updateArea(list);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);

        Admin.frame.repaint();
    }
    public static void showLogin(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(false);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(true);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);
        Admin.frame.repaint();
    }
    public static void showServicePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addDepartment.setVisible(false);
        Admin.frame.addService.setVisible(false);
        Admin.frame.deleteDoctor.setVisible(false);
        Admin.frame.deleteDepart.setVisible(false);
        Admin.frame.deleteService.setVisible(false);
        Admin.frame.viewDepart.setVisible(false);
        Admin.frame.viewDoctor.setVisible(false);
        Admin.frame.viewService.setVisible(true);
        ArrayList<Service> list = listService();
        Admin.frame.viewService.updateArea(list);
        Admin.frame.addDoctor.setVisible(false);
        Admin.frame.login.setVisible(false);
        Admin.frame.doctorpart.setVisible(false);
        Admin.frame.resPart.setVisible(false);
        Admin.frame.servicePart.setVisible(false);
        Admin.frame.departPart.setVisible(false);
        Admin.frame.addRes.setVisible(false);
        Admin.frame.deleteRes.setVisible(false);
        Admin.frame.viewRes.setVisible(false);

        Admin.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}
