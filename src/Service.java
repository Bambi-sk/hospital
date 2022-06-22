import java.io.Serializable;

public class Service implements Serializable {
    private Long id_service;
    private String name;
    private double price;
    private Long id_doctor;
    private String name_department;

    public Service(Long id_service, String name, double price, Long id_doctor, String name_department) {
        this.id_service = id_service;
        this.name = name;
        this.price = price;
        this.id_doctor = id_doctor;
        this.name_department = name_department;
    }

    public String getName_department() {
        return name_department;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }
}
