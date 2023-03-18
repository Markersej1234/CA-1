//package facades;
//
//import dtos.PersonDTO;
//import entities.Person;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.EMF_Creator;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class PersonFacadeTest {
//
//
//    private static EntityManagerFactory emf;
//    private static PersonFacade facade;
//    private Person m1, m2;
//
//
//    @BeforeAll
//    public static void setUpClass()
//    {
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//        facade = PersonFacade.getInstance(emf);
//
//    }
//
//    @BeforeEach
//    void setUp()
//    {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
//            m1 = new Person("mark@gmail.dk","Hans","Bo");
//            m2 = new Person("Hans@bo.dk" , "bobobo", "bobo");
//
//            em.persist(m1);
//            em.persist(m2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @Test
//    void getAllPersons()  {
//        List<PersonDTO> personDTOList = facade.getAllPersons();
//        int expected = 2;
//        int actual = personDTOList.size();
//        assertEquals(expected, actual);
//        assertThat(personDTOList, containsInAnyOrder(new PersonDTO(m1), new PersonDTO(m2)));
//    }
//
//    @Test
//    void createPerson() {
//        //ændrer i PersonDTO mangler id hvad fuck er long, det burde bare være et tal
//        facade.createPerson(new PersonDTO("Hans", "Hans", "Hans@Hans", "1234"));
//        assertEquals(3, facade.getPersonCount());
//    }
//}
