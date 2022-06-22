import java.io.Serializable;

public class AdminObject extends Staff  implements Serializable {
    public AdminObject(Long id_staff, String login, String password, String name, String surname) {
        super(id_staff, login, password, name, surname);
    }
}
