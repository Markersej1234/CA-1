package entities;


import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", length = 30)
    private String number;

    @Column(name = "description", length = 30)
    private String description;

    @ManyToOne
    @JoinColumn(name="PERSON_ID", referencedColumnName = "id")
    private Person person;

    // many to one person
    @ManyToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}