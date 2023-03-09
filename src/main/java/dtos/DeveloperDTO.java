package dtos;

import entities.Developer;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String billingPrHour;

    public DeveloperDTO() {
    }

    public DeveloperDTO(Developer rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.email = rm.getEmail();
        this.phone = rm.getPhone();
        this.billingPrHour = rm.getBillingPrHour();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBillingPrHour() {
        return billingPrHour;
    }

    public void setBillingPrHour(String billingPrHour) {
        this.billingPrHour = billingPrHour;
    }

    public static List<DeveloperDTO> getDtos(List<Developer> rms) {
        List<DeveloperDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new DeveloperDTO(rm)));
        return rmdtos;
    }

}
