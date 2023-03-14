package facades;

import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.Hobby;
import entities.Person;
import entities.RenameMe;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;
import utils.EMF_Creator;

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
    
    public PersonDTO createPerson(PersonDTO personDTO){
        Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail(),personDTO.getPassword());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    public PersonDTO update(PersonDTO personDTO){
        EntityManager em = getEntityManager();
        Person person = (em.find(Person.class, personDTO.getId()));
        try {
            person.setFirstName(person.getFirstName()); person.setLastName(person.getLastName()); person.setEmail(person.getEmail());
            em.getTransaction().begin();
            person = em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
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

    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> rms = query.getResultList();
        System.out.println(rms);
        return PersonDTO.getDtos(rms);
    }
}
