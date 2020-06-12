/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author XC
 */
public class MyEntityManager {
    public javax.persistence.EntityManager entityManager;
    
    public javax.persistence.EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pl.dbabinski.persistance-office");
        if(entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;   
    }
}
