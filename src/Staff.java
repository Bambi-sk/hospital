import java.io.Serializable;

public class Staff implements Serializable {
    private Long id_staff;
    private String login;
    private String password;

    private String name;
    private String surname;


    public Staff(){}

    public Staff(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Staff(Long id_staff, String login, String password, String name, String surname) {
        this.id_staff = id_staff;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;

    }

    public Long getId_staff() {
        return id_staff;
    }

    public void setId_staff(Long id_staff) {
        this.id_staff = id_staff;
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
}
