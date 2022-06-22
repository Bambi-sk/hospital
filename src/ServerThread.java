import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject())!=null) {
                if(pd.getCode().equals("list_admin")){
                    ArrayList<AdminObject> adminss = getAdmin();
                    PackageData resp = new PackageData();
                    resp.setAdmins(adminss);
                    outputStream.writeObject(resp);
                }
                else if(pd.getCode().equals("list_doctor")){
                    ArrayList<Doctor> doctors = getDoctors();
                    PackageData resp = new PackageData();
                    resp.setDoctors(doctors);
                    outputStream.writeObject(resp);

                }
                else if(pd.getCode().equals("list_department")){
                    ArrayList<department> deps = getDepartments();
                    PackageData resp = new PackageData();
                    resp.setDepartments(deps);
                    outputStream.writeObject(resp);
                }
                else if(pd.getCode().equals("list_service")){
                    ArrayList<Service> services = getServices();
                    PackageData resp = new PackageData();
                    resp.setServices(services);
                    outputStream.writeObject(resp);

                }
                else if(pd.getCode().equals("list_bill")){
                    ArrayList<Bill> bills = getBill();
                    PackageData resp = new PackageData();
                    resp.setBills(bills);
                    outputStream.writeObject(resp);

                }
                else if(pd.getCode().equals("list_patient")){
                    ArrayList<Patient> patients = getPatients();
                    PackageData resp = new PackageData();
                    resp.setPatients(patients);
                    outputStream.writeObject(resp);
                }
                else if(pd.getCode().equals("add_patient")){
                    try {
                        Patient patient= pd.getPatient();
                        addPatient(patient);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getCode().equals("add_bill")){
                    try {
                        Bill bill= pd.getBill();
                        addBill(bill);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getCode().equals("add_doctor")){
                    try {
                        Doctor doctor = pd.getDoctor();
                        addDoctor(doctor);
                        System.out.println("bb");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                else if(pd.getCode().equals("add_dep")){
                    try {
                        department dep= pd.getDepartment();
                        addDep(dep);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                else if(pd.getCode().equals("add_service")){
                    try {
                        Service ser= pd.getService();
                        addService(ser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getCode().equals("delete_dep")){
                    Long id=pd.getId();
                    removeDepartmnet(id);

                }
                else if(pd.getCode().equals("delete_service")){
                    Long id=pd.getId();
                    removeService(id);
                }
                else if(pd.getCode().equals("delete_doctor")){
                    Long id=pd.getId();
                    removeDoctor(id);
                }
//                else if(pd.getCode().equals("edit_patient")){
//                    Long id=pd.getId();
//                    Long id_bills=pd.getId_bills();
//                    Long id_service=pd.getId_service();
//                    updatePatient(id,id_service,id_bills);
//                }
                else if(pd.getCode().equals("add_record")){
                    try {
                        Record record= pd.getRecord();
                        addRecord(record);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getCode().equals("list_record")){
                    ArrayList<Record> records= getRecords();
                    PackageData resp = new PackageData();
                    resp.setRecords(records);
                    outputStream.writeObject(resp);
                }
                else if(pd.getCode().equals("remove_record")){
                    Long id=pd.getId();
                    removeRecord(id);

                }
                else if(pd.getCode().equals("add_res")){
                    try {
                        System.out.println("yes thread");
                        Res res= pd.getRes();
                        addRes(res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getCode().equals("remove_res")){
                    Long id=pd.getId();
                    removeRes(id);
                }
                else if(pd.getCode().equals("list_res")){
                    ArrayList<Res> res= getRes();
                    PackageData resp = new PackageData();
                    resp.setResArrayList(res);
                    outputStream.writeObject(resp);

                }
                else if(pd.getCode().equals("edit_record")){

                        Long id=pd.getId();
                        String bill_name=pd.getBill_name();
                        String bill_description=pd.getBill_description();
                        updateRecord(id,bill_name,bill_description);

                }
                else{
                    break;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add_admin() {
        String insert = "INSERT INTO admin (id, login, password, name, surname) VALUES (NULL,?,?,?,?)";

        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, "admin");
            prst.setString(2, "admin1234");
            prst.setString(3, "bota");
            prst.setString(4, "skander");
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addBill(Bill bill){
        String insert = "INSERT INTO bill (id,bill_name,description,) VALUES (NULL,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, bill.getName());
            prst.setString(2, bill.getDescription());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDoctor(Doctor doctor) {
        String insert = "INSERT INTO doctor (id_staff, login, password, name, surname,spes, id_department) VALUES (NULL,?,?,?,?,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, doctor.getLogin());
            prst.setString(2, doctor.getPassword());
            prst.setString(3, doctor.getName());
            prst.setString(4, doctor.getSurname());
            prst.setString(5, doctor.getSpes());
            prst.setString(6,doctor.getId_department());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient(Patient patient) {
        String insert = "INSERT INTO patient (patient_id,patient_name,patient_surname) VALUES (NULL,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, patient.getName());
            prst.setString(2, patient.getSurname());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addService(Service service) {
        String insert = "INSERT INTO service (id_service,name,price,id_doctor,id_department) VALUES (NULL,?,?,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, service.getName());
            prst.setDouble(2, service.getPrice());
            prst.setLong(3, service.getId_doctor());
            prst.setString(4,service.getName_department());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addDep(department dep) {
        String insert = "INSERT INTO departament (id,name) VALUES (NULL,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1, dep.getName());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Service> getServices(){
        ArrayList<Service> services = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM service";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                services.add(new Service(res.getLong("id_service"),res.getString("name"),res.getDouble("price"),res.getLong("id_doctor"),res.getString("id_department")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;

    }
    public ArrayList<Patient> getPatients(){
        ArrayList<Patient> patients = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM patient";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                patients.add(new Patient(res.getLong("patient_id"),res.getString("patient_name"),res.getString("patient_surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
        public ArrayList<department> getDepartments(){
        ArrayList<department> departments=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM departament";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                departments.add(new department(res.getLong("id"),res.getString("name")));

            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;

    }
    public ArrayList<Doctor> getDoctors(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM doctor";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                doctors.add(new Doctor(res.getLong("id_staff"),res.getString("login"),res.getString("password"),res.getString("name"),res.getString("surname"),res.getString("spes"),res.getString("id_department")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
    public ArrayList<Bill> getBill(){
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM bill";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                bills.add(new Bill(res.getString("bill_name"),res.getString("description"),res.getLong("id")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }
    public ArrayList<AdminObject> getAdmin(){
        ArrayList<AdminObject> admins = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                admins.add(new AdminObject(res.getLong("id"),res.getString("login"),res.getString("password"),res.getString("name"),res.getString("surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;

    }
    public void removeDoctor(Long id){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM doctor WHERE id_staff = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            for (int i=0;i<getServices().size();i++){
                if(getServices().get(i).getId_doctor()==id){
                    PreparedStatement st = connection.prepareStatement("DELETE FROM service WHERE id_service = ?");
                    st.setLong(1, id);
                    st.executeUpdate();
                    st.close();

                }
            }
            ps.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void removeService(Long id){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM service WHERE id_service = ?");
            ps.setLong(1, id);
            ps.executeUpdate();


            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void removeDepartmnet(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM departament WHERE id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//    public void updatePatient(Long id,Long id_service,Long id_bill){
//        String update = "UPDATE patient SET bill_id = ?,id_service = ? WHERE patient_id = ? ";
//        try {
//            PreparedStatement ps = connection.prepareStatement(update);
//            ps.setLong(1,id_bill);
//            ps.setLong(2,id_service);
//            ps.setLong(3,id);
//            ps.executeUpdate();
//
//            ps.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public void updateRecord(Long id,String bill_name,String bill_description){
        String update = "UPDATE record SET bill_name = ?, bill_description = ? WHERE id_record = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1,bill_name);
            ps.setString(2,bill_description);
            ps.setLong(3,id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addRecord(Record record){
        String insert = "INSERT INTO record (id_record, id_doctor, id_patient, id_service, bill_name, bill_description) VALUES (NULL,?,?,?,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1,record.getId_doctor());
            prst.setString(2, record.getId_patient());
            prst.setString(3,record.getId_service());
            prst.setString(4,record.getBill_name());
            prst.setString(5,record.getBill_description());

            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Record> getRecords(){
        ArrayList<Record> records = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM record";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                records.add(new Record(res.getLong("id_record"),res.getString("id_doctor"),res.getString("id_patient"),res.getString("id_service"),res.getString("bill_name"),res.getString("bill_description")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }


    public  void removeRecord(Long id){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM record WHERE id_record = ?");
            ps.setLong(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addRes(Res res){
        String insert = "INSERT INTO res (id_res, login, password) VALUES (NULL,?,?)";
        try {
            PreparedStatement prst = connection.prepareStatement(insert);
            prst.setString(1,res.getLogin());
            prst.setString(2, res.getPassword());
            prst.executeUpdate();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  ArrayList<Res> getRes(){
        ArrayList<Res> res1 = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM res";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                res1.add(new Res(res.getLong("id_res"),res.getString("login"),res.getString("password")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res1;
    }
    public void removeRes(Long id){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM res WHERE id_res = ?");
            ps.setLong(1, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}




