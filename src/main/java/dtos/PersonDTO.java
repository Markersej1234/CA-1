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

    public PersonDTO(Long id, String email, String firstName, String lastName, String password) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public PersonDTO(Person person) {
    }


    public static List<PersonDTO> getDtos(List<Person> persons){
        List<PersonDTO> personDTOs = new ArrayList();
        persons.forEach(person -> personDTOs.add(new PersonDTO(person.getId(), person.getEmail(), person.getFirstName(), person.getLastName(), person.getPassword())));
        return personDTOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PhoneDTO> getPhone() {
        return phone;
    }

    public void setPhone(Set<PhoneDTO> phone) {
        this.phone = phone;
    }

    public Set<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Long getCityInfo_id() {
        return cityInfo_id;
    }

    public void setCityInfo_id(Long cityInfo_id) {
        this.cityInfo_id = cityInfo_id;
    }

    public Set<Long> getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(Set<Long> hobby_id) {
        this.hobby_id = hobby_id;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
