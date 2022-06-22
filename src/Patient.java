import java.io.Serializable;

public class Patient implements Serializable {
    private Long id_patient;
    private String name;
    private String surname;


    public Patient(Long id_patient, String name, String surname) {
        this.id_patient = id_patient;
        this.name = name;
        this.surname = surname;

    }


    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }




}
