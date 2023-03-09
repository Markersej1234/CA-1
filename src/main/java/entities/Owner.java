package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Owner {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String name;
    private String address;
    private String phone;

    public Owner() {
    }

    @ManyToMany()
    private List<Boat> boatList = new ArrayList<>();

    public Owner(int id, String name,  String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void addBoat(Boat boat) {

        if (boat != null) {
            this.boatList.add(boat);
            boat.getOwners().add(this);

        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}