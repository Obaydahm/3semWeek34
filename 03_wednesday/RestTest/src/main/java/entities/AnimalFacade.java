/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Obaydah Mohamad
 */
public class AnimalFacade {
    private static EntityManagerFactory emf;
    private static AnimalFacade instance;
    
    public static AnimalFacade getInstance(EntityManagerFactory emf_){
        if(instance == null){
            instance = new AnimalFacade();
            emf = emf_;
        }
        return instance;
    }
    
    public List<Animal1> allAnimals(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Animal1> query = em.createQuery("SELECT a FROM Animal1 a", Animal1.class);
            return query.getResultList();
        }finally{
            em.close();
        }
    }
    
    public Animal1 findByID(Long id){
        EntityManager em = emf.createEntityManager();
        try{
            Animal1 a = em.find(Animal1.class, id);
            return a;
        }finally{
            em.close();
        }
    }

}
