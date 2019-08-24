/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Obaydah Mohamad
 */
public class EmployeeFacade {
    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /*
    getEmployeeById
    getEmployeesByName
    getAllEmployees
    getEmployeesWithHighestSalary
    createEmployee
    */
    
    public Employee getEmployeeById(Long id){
        try{
            return getEntityManager().find(Employee.class, id);
        }finally{
            getEntityManager().close();
        }
    }
    
    public List<Employee> getEmployeesByName(String name){
        try{
            TypedQuery tq = getEntityManager().createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class);
            tq.setParameter("name", name);
            return tq.getResultList();
        }finally{
            getEntityManager().close();
        }
    }
    
    public List<Employee> getAllEmployees(){
        try{
            TypedQuery tq = getEntityManager().createQuery("SELECT e FROM Employee e", Employee.class);
            return tq.getResultList();
        }finally{
            getEntityManager().close();
        }
    }
    
    public List<Employee> getEmployeesWithHighestSalary(){
        try{
            TypedQuery tq = getEntityManager().createQuery("SELECT e FROM Employee e ORDER BY e.salary DESC", Employee.class);
            return tq.getResultList();
        }finally{
            getEntityManager().close();
        }
    }
    
    public Employee createEmployee(Employee e){
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(e);
            getEntityManager().getTransaction().commit();
            return e;
        }finally{
            getEntityManager().close();
        }
    }
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Employee("Phillip Jenesen", "Phillipstreet", 100));
        em.persist(new Employee("Obaydah Jenesen", "OBStreet", 100000000));
        em.persist(new Employee("Sinan Jenesen", "SinanStreet", -10500));
        em.persist(new Employee("Thomas Jenesen", "ThomasStreet", 2000));
        em.persist(new Employee("Shpat Jenesen", "LadOSBigStreet", 0));
        em.getTransaction().commit();
    }
}
