/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Obaydah Mohamad
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        //BankCustomer bc = new BankCustomer(firstName, lastName, accountNumber, 0, 0, internalInfo);
        try {
            em.getTransaction().begin();
            em.persist(new BankCustomer("Jim", "Clark", "000-0001", 10000.50, 4, "active"));
            em.persist(new BankCustomer("Phil", "Jacobsen", "000-0002", 0.50, 6, "active"));
            em.persist(new BankCustomer("Will", "Smith", "000-0003", 2340015.50, 3, "active"));
            em.persist(new BankCustomer("Ryan", "Reyonlds", "000-0004", 5543.50, 5, "active"));
            em.persist(new BankCustomer("Tony", "Stark", "000-0005", 2330445400.50, 1, "active"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
