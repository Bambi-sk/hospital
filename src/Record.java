import java.io.Serializable;

public class Record implements Serializable {
    private Long id_rec;
    private String id_doctor;
    private String id_patient;
    private String id_service;
    private String bill_name;
    private String bill_description;

    public Record(Long id_rec, String id_doctor, String id_patient, String id_service, String bill_name, String bill_description) {
        this.id_rec = id_rec;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_service = id_service;
        this.bill_name = bill_name;
        this.bill_description = bill_description;
    }

    public void setId_doctor(String id_doctor) {
        this.id_doctor = id_doctor;
    }

    public void setId_service(String id_service) {
        this.id_service = id_service;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getBill_description() {
        return bill_description;
    }

    public String getId_doctor() {
        return id_doctor;
    }

    public String getId_service() {
        return id_service;
    }

    public void setBill_description(String bill_description) {
        this.bill_description = bill_description;
    }

    public String getId_patient() {
        return id_patient;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    public Long getId_rec() {
        return id_rec;
    }

    public void setId_rec(Long id_rec) {
        this.id_rec = id_rec;
    }




}
