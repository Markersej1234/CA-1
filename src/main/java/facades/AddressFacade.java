package facades;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AddressFacade {


    private static AddressFacade instance;
    private static EntityManagerFactory emf;

    public static AddressFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
    }

    //Private Constructor to ensure Singleton
    private AddressFacade() {
    }


    public void deleteAddress(int pn) {
        EntityManager em = emf.createEntityManager();
        Address a = (em.find(Address.class, (long) pn));
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
