import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String code;
    private ArrayList<Doctor> doctors;
    private ArrayList<Service> services;
    private ArrayList<AdminObject> admins;
    private ArrayList<Bill> bills;
    private ArrayList<Patient> patients;
    private ArrayList<department> departments;
    private String login;
    private String password;
    private Doctor doctor;
    private Service service;
    private Patient patient;
    private department department;
    private Bill bill;
    private Long id_patient_current;
    private Record record;
    private ArrayList<Record> records;
    private Res res;
    private ArrayList<Res> resArrayList;

    Long id;
    Long id_bills;
    Long id_service;
    String bill_name;
    String bill_description;

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getBill_description() {
        return bill_description;
    }

    public void setBill_description(String bill_description) {
        this.bill_description = bill_description;
    }

    public Long getId_bills() {
        return id_bills;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Long getId_patient_current() {
        return id_patient_current;
    }

    public void setId_patient_current(Long id_patient_current) {
        this.id_patient_current = id_patient_current;
    }

    public void setId_bills(Long id_bills) {
        this.id_bills = id_bills;
    }

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PackageData() {
    }

    public PackageData(String code, String login, String password) {
        this.code=code;
        this.login = login;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<AdminObject> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<AdminObject> admins) {
        this.admins = admins;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<department> departments) {
        this.departments = departments;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        this.department = department;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

    public ArrayList<Res> getResArrayList() {
        return resArrayList;
    }

    public void setResArrayList(ArrayList<Res> resArrayList) {
        this.resArrayList = resArrayList;
    }
}
