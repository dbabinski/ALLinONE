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
public class TableModelUsers {
    private static TableModelUsers instance;
    public static TableModelUsers getInstance(){
        if (instance == null){
        instance = new TableModelUsers();
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
    
    public Users getById(final int id){
        return entityManager.find(Users.class, id);
    }
    
    public List<Users> findAll() {
        return entityManager.createNamedQuery("Users.findAll").getResultList();
    }
    
    public void persist(Users users){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(users);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge (Users users) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(users);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove (Users users) {
        try {
            entityManager.getTransaction().begin();
            users = entityManager.find(Users.class, users.getId());
            entityManager.remove(users);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
           entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById (final int id) {
        try {
            Users users = getById(id);
            remove(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
