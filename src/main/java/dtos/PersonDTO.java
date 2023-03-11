package dtos;

import entities.Person;


import java.util.*;

public class PersonDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Set<PhoneDTO> phone;
    private Set<HobbyDTO> hobbies;
    private AddressDTO address;
    private Long cityInfo_id;
    private Set<Long> hobby_id;

    public PersonDTO(Long id, String email, String firstName, String lastName, String password, Set<PhoneDTO> phone, Set<HobbyDTO> hobbies, AddressDTO address, Long cityInfo_id, Set<Long> hobby_id) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.hobbies = hobbies;
        this.address = address;
        this.cityInfo_id = cityInfo_id;
        this.hobby_id = hobby_id;
    }

    public PersonDTO(Person person) {
    }

    public static List<PersonDTO> getDtos(List<Person> persons){
        List<PersonDTO> personDTOs = new ArrayList();
        persons.forEach(person -> personDTOs.add(new PersonDTO(person)));
        return personDTOs;
    }

}
