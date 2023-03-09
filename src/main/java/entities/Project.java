package entities;

import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name = "Project.deleteAllRows", query = "DELETE from Project ")
public class Project {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "projectList")
    private List<Developer> developerList;

    @OneToMany(mappedBy = "project")
    private List<ProjectHours> projectHoursList;

    public Project() {
    }

    public Project(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<Developer> getDevelopers() {
        return developerList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }

    public List<ProjectHours> getProjectHoursList() {
        return projectHoursList;
    }

    public void setProjectHoursList(List<ProjectHours> projectHoursList) {
        this.projectHoursList = projectHoursList;
    }
}
