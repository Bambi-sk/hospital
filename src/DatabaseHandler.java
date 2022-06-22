//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class DatabaseHandler  {
//    Connection dbconnection;
//
//    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useUnicode=true&serverTimezone=UTC", "root", "");
//        return dbconnection;
//    }
//
//    public void add_admin() {
//        String insert = "INSERT INTO admin (id, login, password, name, surname) VALUES (NULL,?,?,?,?)";
//
//        try {
//            PreparedStatement prst = getDbconnection().prepareStatement(insert);
//            prst.setString(1, "admin");
//            prst.setString(2, "admin1234");
//            prst.setString(3, "bota");
//            prst.setString(4, "skander");
//            prst.executeUpdate();
//            prst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void addDoctor(Doctor doctor) {
//        String insert = "INSERT INTO doctor (id, login, password, name, surname,spes) VALUES (NULL,?,?,?,?,?)";
//        try {
//            PreparedStatement prst = getDbconnection().prepareStatement(insert);
//            prst.setString(1, doctor.getLogin());
//            prst.setString(2, doctor.getPassword());
//            prst.setString(3, doctor.getName());
//            prst.setString(4, doctor.getSurname());
//            prst.setString(5, doctor.getSpes());
//            prst.executeUpdate();
//            prst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addPatient(Patient patient) {
//        String insert = "INSERT INTO patient (patient_id,patient_name,patient_surname,day_birth,month_birth,year_birth,bill_id,id_service) VALUES (NULL,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement prst = getDbconnection().prepareStatement(insert);
//            prst.setString(1, patient.getName());
//            prst.setString(2, patient.getSurname());
//            prst.setInt(3, patient.getDate_of_birth_day());
//            prst.setInt(4, patient.getDate_of_birth_month());
//            prst.setInt(5, patient.getDate_of_birth_year());
//            prst.setInt(6, patient.getDate_of_birth_day());
//            prst.setLong(7, patient.getId_bill());
//            prst.setLong(8, patient.getId_service());
//
//            prst.executeUpdate();
//            prst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public void addService(Service service) {
//        String insert = "INSERT INTO service (id_service,name,price,id_doctor) VALUES (NULL,?,?,?)";
//        try {
//            PreparedStatement prst = getDbconnection().prepareStatement(insert);
//            prst.setString(1, service.getName());
//            prst.setDouble(2, service.getPrice());
//            prst.setLong(3, service.getId_doctor());
//            prst.executeUpdate();
//            prst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public void add(Service service) {
//        String insert = "INSERT INTO service (id_service,name,price,id_doctor) VALUES (NULL,?,?,?)";
//        try {
//            PreparedStatement prst = getDbconnection().prepareStatement(insert);
//            prst.setString(1, service.getName());
//            prst.setDouble(2, service.getPrice());
//            prst.setLong(3, service.getId_doctor());
//            prst.executeUpdate();
//            prst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<Service> getServices(){
//        ArrayList<Service> services = new ArrayList<>();
//        try {
//            Statement st = dbconnection.createStatement();
//            String sql = "SELECT * FROM service";
//            ResultSet res = st.executeQuery(sql);
//            while(res.next()){
//                services.add(new Service(res.getLong("id_service"),res.getString("name"),res.getDouble("price"),res.getLong("id_doctor")));
//            }
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return services;
//
//    }
//    public ArrayList<Patient> getPatients(){
//        ArrayList<Patient> patients = new ArrayList<>();
//        try {
//            Statement st = dbconnection.createStatement();
//            String sql = "SELECT * FROM patient";
//            ResultSet res = st.executeQuery(sql);
//            while(res.next()){
//                patients.add(new Patient(res.getLong("patient_id"),res.getString("patient_name"),res.getString("patient_surname"),res.getInt("day_birth"),res.getInt("month_birth"),res.getInt("year_birth"),res.getLong("bill_id"),res.getLong("id_service")));
//            }
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return patients;
//    }
////    public ArrayList<department> getDepartments(){
////        ArrayList<department> departments=new ArrayList<>();
////        try {
////            Statement st = dbconnection.createStatement();
////            String sql = "SELECT * FROM departament";
////            ResultSet res = st.executeQuery(sql);
////            while(res.next()){
////                departments.add(new department(res.getString("name")));
////                for (int i=0;i<departments.size();i++) {
////                    if (departments.get(i).getName().equals(res.getString("name"))){
////                        ar
////                        departments.add(res.getString("name"),res.getLong("id"))
////                    }
////                }
////            }
////            st.close();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return departments;
////
////    }
//    public ArrayList<Doctor> getDoctors(){
//        ArrayList<Doctor> doctors = new ArrayList<>();
//        try {
//            Statement st = dbconnection.createStatement();
//            String sql = "SELECT * FROM doctor";
//            ResultSet res = st.executeQuery(sql);
//            while(res.next()){
//                doctors.add(new Doctor(res.getLong("id_staff"),res.getString("login"),res.getString("password"),res.getString("name"),res.getString("surname"),res.getString("spes")));
//            }
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return doctors;
//    }
//    public ArrayList<Bill> getBill(){
//        ArrayList<Bill> bills = new ArrayList<>();
//        try {
//            Statement st = dbconnection.createStatement();
//            String sql = "SELECT * FROM bill";
//            ResultSet res = st.executeQuery(sql);
//            while(res.next()){
//                bills.add(new Bill(res.getString("bill_name"),res.getString("description"),res.getString("date_first"),res.getString("date_second"),res.getLong("id"),res.getLong("id_staff")));
//            }
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bills;
//    }
//    public ArrayList<AdminObject> getAdmin(){
//        ArrayList<Admin> admins = new ArrayList<>();
//        try {
//            Statement st = dbconnection.createStatement();
//            String sql = "SELECT * FROM bill";
//            ResultSet res = st.executeQuery(sql);
//            while(res.next()){
//                admins.add(new Admin(res.getLong("id"),res.getString("login"),res.getString("password"),res.getString("name"),res.getString("surname")));
//            }
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return admins;
//
//    }
//    public void removeDoctor(Long id){
//        try {
//            PreparedStatement ps = dbconnection.prepareStatement("DELETE FROM doctor WHERE id_staff = ?");
//            ps.setLong(1, id);
//            ps.executeUpdate();
//            for (int i=0;i<getServices().size();i++){
//                if(getServices().get(i).getId_doctor()==id){
//                    PreparedStatement st = dbconnection.prepareStatement("DELETE FROM service WHERE id_service = ?");
//                    st.setLong(1, id);
//                    st.executeUpdate();
//                    st.close();
//
//                }
//            }
//            ps.close();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void removeService(Long id){
//        try {
//            PreparedStatement ps = dbconnection.prepareStatement("DELETE FROM service WHERE id_service = ?");
//            ps.setLong(1, id);
//            ps.executeUpdate();
//
//
//            ps.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void removeDepartmnet(String name){
//        try {
//            PreparedStatement ps = dbconnection.prepareStatement("DELETE FROM departament WHERE name = ?");
//            ps.setString(1,name);
//            ps.executeUpdate();
//
//            ps.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void updatePatient(Long id,Long id_service,Long id_bill){
//        String update = "UPDATE patient SET bill_id = ?,id_service = ? WHERE patient_id = ? ";
//        try {
//            PreparedStatement ps = dbconnection.prepareStatement(update);
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
//
//
//
//
//}
