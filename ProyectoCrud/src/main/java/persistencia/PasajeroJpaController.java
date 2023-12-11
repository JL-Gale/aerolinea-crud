
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Pasajero;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

public class PasajeroJpaController implements Serializable {

    public PasajeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public  PasajeroJpaController(){
        emf = Persistence.createEntityManagerFactory("aerolineaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pasajero pasajero) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pasajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPasajero(pasajero.getAsiento()) != null) {
                throw new PreexistingEntityException("Pasajero " + pasajero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pasajero pasajero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pasajero = em.merge(pasajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pasajero.getAsiento();
                if (findPasajero(id) == null) {
                    throw new NonexistentEntityException("The pasajero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pasajero pasajero;
            try {
                pasajero = em.getReference(Pasajero.class, id);
                pasajero.getAsiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pasajero with id " + id + " no longer exists.", enfe);
            }
            em.remove(pasajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pasajero> findPasajeroEntities() {
        return findPasajeroEntities(true, -1, -1);
    }

    public List<Pasajero> findPasajeroEntities(int maxResults, int firstResult) {
        return findPasajeroEntities(false, maxResults, firstResult);
    }

    private List<Pasajero> findPasajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pasajero.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pasajero findPasajero(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pasajero.class, id);
        } finally {
            em.close();
        }
    }

    public int getPasajeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pasajero> rt = cq.from(Pasajero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
