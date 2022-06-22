import java.io.Serializable;

public class Doctor extends Staff implements Serializable {

    private String spes;
    private String  id_department;


//
//    public Doctor(){}

    public Doctor(Long id_staff, String login, String password, String name, String surname, String spes, String id_department) {
        super(id_staff, login, password, name, surname);
        this.spes = spes;
        this.id_department = id_department;
    }

    public String getId_department() {
        return id_department;
    }

    public void setId_department(String id_department) {
        this.id_department = id_department;
    }

    public String getSpes() {
        return spes;
    }


    public void setSpes(String spes) {
        this.spes = spes;
    }

}
