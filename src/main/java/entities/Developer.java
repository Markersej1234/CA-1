package entities;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Developer {
    private static final long serialVersionUID = 1L;
    @Id

    private int id;
    private String name;
    private String email;
    private String phone;
    private String billingPrHour;

    @ManyToMany()
    private List<Project> projectList = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    private List<ProjectHours> projectHoursList;

    public void addProject(Project project) {

        if (project != null) {
            this.projectList.add(project);
            project.getDevelopers().add(this);

        }


    }

    public Developer() {
    }

    public Developer(int id, String name, String email, String phone, String billingPrHour) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.billingPrHour = billingPrHour;
    }

    public Developer(String name, String email, String phone, String billingPrHour) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.billingPrHour = billingPrHour;
    }

//    public Developer(int id, String name, String email, String phone, String billingPrHour){
//
//    }


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
}
