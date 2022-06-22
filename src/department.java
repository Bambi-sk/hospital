import java.io.Serializable;

public class department implements Serializable {
    private Long id_department;
    private String name;



    public String getName() {
        return name;
    }

    public department(Long id_department, String name) {
        this.id_department = id_department;
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_department() {
        return id_department;
    }

    public void setId_department(Long id_department) {
        this.id_department = id_department;
    }


}
