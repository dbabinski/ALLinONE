/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.dbabinski.jdbc.entity.Users;
import pl.dbabinski.jdbc.tables.TableModelUsers;

/**
 *
 * @author damian
 */
public class UsersDAO {
    
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
}
