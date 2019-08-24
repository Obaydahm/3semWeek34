package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new CustomerDTO(em.find(BankCustomer.class, Long.valueOf(id)));
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name) {
        List<CustomerDTO> list = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery tq = em.createQuery("SELECT c FROM BankCustomer c WHERE c.lastname = :lastname", BankCustomer.class);
            tq.setParameter("lastname", name);
            List<BankCustomer> bcList = tq.getResultList();
            for(BankCustomer bc : bcList){
                list.add(new CustomerDTO(bc));
            }
            return list;
        } finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer bc) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bc);
            em.getTransaction().commit();
            return bc;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery tq = em.createQuery("SELECT c FROM BankCustomer c", BankCustomer.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }
}
