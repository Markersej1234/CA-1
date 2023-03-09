package dtos;

import entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerDTO {
    private int id;
    private String name;
    private String address;
    private String phone;



    public OwnerDTO(Owner rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.address = rm.getAddress();
        this.phone = rm.getPhone();
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

    public static List<OwnerDTO> getDtos(List<Owner> rms) {
        List<OwnerDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new OwnerDTO(rm)));
        return rmdtos;
    }
}