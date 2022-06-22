import java.io.Serializable;

public class Bill implements Serializable {
    private Long id_bill;
    private String name;
    private String description;


    public Bill(String name, String description,  Long id_bill) {
        this.name = name;
        this.description = description;

        this.id_bill = id_bill;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_bill() {
        return id_bill;
    }

    public void setId_bill(Long id_bill) {
        this.id_bill = id_bill;
    }

}
