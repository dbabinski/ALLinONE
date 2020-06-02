/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author damian
 */
public class TableModelUsersCategory {
    private static TableModelUsersCategory instance;
    public static TableModelUsersCategory getInstance(){
        if (instance == null){
        instance = new TableModelUsersCategory();
        }
                
        return instance;
    };
    
    public EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pl.dbabinski.persistance-office");
        if(entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;   
    }
    
    public UsersCategory getById(final int id){
        return entityManager.find(UsersCategory.class, id);
    }
    
    public List<UsersCategory> findAll() {
        return entityManager.createNamedQuery("UsersCategory.findAll").getResultList();
    }
    
    public void persist(UsersCategory usersCategory){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usersCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge (UsersCategory usersCategory) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usersCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove (UsersCategory usersCategory) {
        try {
            entityManager.getTransaction().begin();
            usersCategory = entityManager.find(UsersCategory.class, usersCategory.getId());
            entityManager.remove(usersCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
           entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById (final int id) {
        try {
            UsersCategory usersCategory = getById(id);
            remove(usersCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
