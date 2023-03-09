package dtos;

import entities.Harbour;

import java.util.ArrayList;
import java.util.List;

public class HarbourDTO {
    private int id;
    private String name;
    private String address;
    private int capacity;


    public HarbourDTO(Harbour rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.address = rm.getAddress();
        this.capacity = rm.getCapacity();
    }

    public HarbourDTO(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static List<HarbourDTO> getDtos(List<Harbour> rms) {
        List<HarbourDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new HarbourDTO(rm)));
        return rmdtos;
    }
}
