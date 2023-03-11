package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 30)
    private String description;

    @ManyToMany
    @JoinTable(name = "personhobby",
            joinColumns = @JoinColumn(name = "hobby_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> person = new LinkedHashSet<>();

    public Hobby(){
    }




//    public Set<Hobby> getHobbies() {
//        return hobbies;
//    }
//
//    public void setHobbies(Set<Hobby> hobbies) {
//        this.hobbies = hobbies;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return id != null && Objects.equals(id, hobby.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}