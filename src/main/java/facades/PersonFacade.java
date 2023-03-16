package facades;

import dtos.CityInfoDTO;
import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.PhoneDTO;
import entities.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;


/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Person assignHobby(long hobbyId, long person_id) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, hobbyId);
        Person person = em.find(Person.class, person_id);
        em.getTransaction().begin();
        hobby.addPerson(person);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    public Person assignCityInfo(long cityInfoId, long person_id){
        EntityManager em = emf.createEntityManager();
        CityInfo cityInfo = em.find(CityInfo.class, cityInfoId);
        Person person = em.find(Person.class, person_id);
        em.getTransaction().begin();
        cityInfo.setAddress(person.getAddress());
        em.getTransaction().commit();
        em.close();
        return person;
    }
    
    public PersonDTO createPerson(PersonDTO personDTO){
        Set<Phone> phones = new LinkedHashSet<>();
        for (PhoneDTO p : personDTO.getPhone()) {
            phones.add(new Phone(p.getNumber()));
        }
        Address address = new Address(personDTO.getAddress().getStreet(),personDTO.getAddress().getAdditionalInfo());
        Set<HobbyDTO> hobbies = new LinkedHashSet<>();
        for (long l : personDTO.getHobby_id()){
            hobbies.add(getHobbies(l));
        }
        personDTO.setHobbies(hobbies);
        Person person = new Person(personDTO.getEmail(),personDTO.getFirstName(), personDTO.getLastName());
        address.addPerson(person);
        for (Phone p : phones){
            person.addPhone(p);
        }
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        for(HobbyDTO h :personDTO.getHobbies()) {
            assignHobby(h.getId(), person.getId());
        }
        assignCityInfo(personDTO.getCityInfo_id(),person.getId());
        PersonDTO output = new PersonDTO(person);
        output.setHobbies(personDTO.getHobbies());
        return output;
    }

    public PersonDTO update(PersonDTO person) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Person p = em.merge(person.getEntity()); //implement getEntity
        em.getTransaction().commit();
        em.close();
        return new PersonDTO(p);
    }

    public List<CityInfoDTO> getAllZips() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CityInfo> query = em.createQuery("SELECT c FROM CityInfo c",CityInfo.class );
        List<CityInfo> citys = query.getResultList();
        List<CityInfoDTO> cityDTOS = new ArrayList<>();
        for (CityInfo c : citys) {
            cityDTOS.add(new CityInfoDTO(c));
        }
        return cityDTOS;
    }

//
//    public PersonDTO getById(long id) { //throws RenameMeNotFoundException {
//        EntityManager em = emf.createEntityManager();
//        RenameMe rm = em.find(RenameMe.class, id);
////        if (rm == null)
////            throw new RenameMeNotFoundException("The RenameMe entity with ID: "+id+" Was not found");
//        return new RenameMeDTO(rm);
//    }

    
//    public List<PersonDTO> getAllByHobby(){
//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Hobby> query = em.createQuery("SELECT p FROM Person p", Hobby.class);
//        List<Hobby> hobby = query.getResultList();
//        return PersonDTO.getDtos(Person);
//    }
//
//    public static void main(String[] args) {
//        emf = EMF_Creator.createEntityManagerFactory();
//        PersonFacade fe = getFacadeExample(emf);
//        fe.getAllByHobby().forEach(dto->System.out.println(dto));
//    }

    public List<PersonDTO> getByPhone(String phone) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Person> query = em.createQuery("SELECT p from Person p JOIN p.phone t WHERE t.number = :phoneNumber", Person.class)
                .setParameter("phoneNumber", phone);
        List<Person> persons = query.getResultList();
        List<PersonDTO> personDTOs = new ArrayList<>();
        for (Person p :persons) {
            personDTOs.add(new PersonDTO(p));
        }
        return personDTOs;
    }

    public List<PersonDTO> getByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Person> query = em.createQuery("SELECT p from Person p JOIN p.hobby h where h.name = :hobbyname", Person.class)
                .setParameter("hobbyname", hobby);
        List<Person> persons = query.getResultList();
        List<PersonDTO> personDTOs = new ArrayList<>();

        for (Person p :persons) {
            personDTOs.add(new PersonDTO(p));
        }
        return personDTOs;
    }

    public HobbyDTO getHobbies(long hobby_id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Hobby> query = em.createQuery("SELECT h from Hobby h WHERE h.id = :idh", Hobby.class)
                .setParameter("idh",hobby_id);
        Hobby hobby = query.getSingleResult();
        return new HobbyDTO(hobby);
    }

    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> rms = query.getResultList();
        System.out.println(rms);
        return PersonDTO.getDtos(rms);
    }

    //Til createPersonTest
    public long getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long PersonCount = (long) em.createQuery("SELECT COUNT(p) FROM Person p").getSingleResult();
            return PersonCount;
        } finally {
            em.close();
        }
    }

    public static PersonFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }
}
