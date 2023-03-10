package dtos;

public class PersonDTO {
    private long id;
    private String number;
    private String description;


    public PersonDTO(long id, String number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public PersonDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
