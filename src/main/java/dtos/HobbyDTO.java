package dtos;

import entities.Hobby;

import java.util.ArrayList;
import java.util.List;

public class HobbyDTO {

    private Long id;
    private String hobby_name;
    private  String description;

    public HobbyDTO(Long id, String hobby_name, String description) {
        this.id = id;
        this.hobby_name = hobby_name;
        this.description = description;
    }

    public static List<HobbyDTO> getDtos(List<Hobby> hobbies){
        List<HobbyDTO> hobbyDTOs = new ArrayList<>();
        hobbies.forEach(hobby -> hobbyDTOs.add(new HobbyDTO(hobby)));
        return hobbyDTOs;
    }

    public HobbyDTO(Hobby hobby){
        if (hobby != null){
            this.id = hobby.getId();
            this.hobby_name = hobby.getName();
            this.description = hobby.getDescription();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHobby_name() {
        return hobby_name;
    }

    public void setHobby_name(String hobby_name) {
        this.hobby_name = hobby_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" +
                "id=" + id +
                ", hobby_name='" + hobby_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
