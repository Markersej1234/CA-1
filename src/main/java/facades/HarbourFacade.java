package facades;

import dtos.HarbourDTO;
import entities.Harbour;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HarbourFacade {

    public HarbourFacade() {
    }

    private static HarbourFacade instance;
    private static EntityManagerFactory emf;

    public List<HarbourDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Harbour> query = em.createQuery("SELECT p FROM Harbour p", Harbour.class);
        List<Harbour> rms = query.getResultList();
        return HarbourDTO.getDtos(rms);
    }

    public HarbourDTO createHarbour(HarbourDTO pn) {
        Harbour harbour = new Harbour(pn.getName(), pn.getAddress(), pn.getCapacity());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(harbour);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HarbourDTO(harbour);
    }

    public HarbourDTO updateHarbour(HarbourDTO pn) {
        EntityManager em = emf.createEntityManager();
        Harbour a = (em.find(Harbour.class, pn.getId()));
        try {
            a.setName(pn.getName()); a.setAddress(pn.getAddress()); a.setCapacity(pn.getCapacity());
            em.getTransaction().begin();
            a = em.merge(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HarbourDTO(a);

    }

    public void deleteAuction(int pn) {
        EntityManager em = emf.createEntityManager();
        //id ing fuck det hele
        Harbour a = (em.find(Harbour.class, (long) pn));
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public static HarbourFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HarbourFacade();
        }
        return instance;
    }


}
