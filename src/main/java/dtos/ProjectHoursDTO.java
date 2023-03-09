package dtos;

import entities.ProjectHours;

import java.util.ArrayList;
import java.util.List;

public class ProjectHoursDTO {
    private int id;
    private String hoursSpendt;
    private String userStory;
    private String description;


    public ProjectHoursDTO(ProjectHours rm) {
        this.id = rm.getId();
        this.hoursSpendt = rm.getHoursSpendt();
        this.userStory = rm.getUserStory();
        this.description = rm.getDescription();
    }

    public ProjectHoursDTO(String hoursSpendt, String userStory, String description) {
        this.hoursSpendt = hoursSpendt;
        this.userStory = userStory;
        this.description = description;
    }

    public ProjectHoursDTO() {
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

    public static List<ProjectHoursDTO> getDtos(List<ProjectHours> rms) {
        List<ProjectHoursDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new ProjectHoursDTO(rm)));
        return rmdtos;
    }
}
