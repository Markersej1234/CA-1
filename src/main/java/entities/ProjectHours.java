package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@NamedQuery(name = "ProjectHours.deleteAllRows", query = "DELETE from ProjectHours ")
public class ProjectHours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hoursSpendt;
    private String userStory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;


    @ManyToOne(cascade = CascadeType.ALL)
    private Developer developer;


    public ProjectHours() {
    }

    public ProjectHours(String hoursSpendt, String userStory, String description) {
        this.hoursSpendt = hoursSpendt;
        this.userStory = userStory;
        this.description = description;
    }

    public ProjectHours(int id, String hoursSpendt, String userStory, String description) {
        this.id = id;
        this.hoursSpendt = hoursSpendt;
        this.userStory = userStory;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoursSpendt() {
        return hoursSpendt;
    }

    public void setHoursSpendt(String hoursSpendt) {
        this.hoursSpendt = hoursSpendt;
    }

    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
