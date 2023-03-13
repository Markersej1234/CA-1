package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
    @NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address")
    public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String additinalInfo;

    @OneToMany (mappedBy = "address", cascade = CascadeType.PERSIST)
        private Set<Person> persons = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn (name = "city_info_id", referencedColumnName = "id")
    private CityInfo cityInfo;

    public Address(String street, String additinalInfo) {
        this.street = street;
        this.additinalInfo = additinalInfo;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditinalInfo() {
        return additinalInfo;
    }

    public void setAdditinalInfo(String additinalInfo) {
        this.additinalInfo = additinalInfo;
    }
}

