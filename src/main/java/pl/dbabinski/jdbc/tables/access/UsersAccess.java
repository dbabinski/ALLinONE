/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.access;

import pl.dbabinski.jdbc.entitymanager.MyEntityManager;
import java.sql.SQLException;
import java.util.List;
import pl.dbabinski.jdbc.entity.Users;
import pl.dbabinski.jdbc.tables.TableModelUsers;

/**
 *
 * @author damian
 */
public class UsersAccess extends MyEntityManager implements I_UsersAccess{
    
    private static TableModelUsers instance;
    public static TableModelUsers getInstance(){
        if (instance == null){
        instance = new TableModelUsers();
        }
                
        return instance;
    };
    
    
    public Users getById(final int id){
        return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> findAll() {
        return entityManager.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public void persist(Users o) throws SQLException {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Users o) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(o);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void remove(Users o) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            o = entityManager.find(Users.class, o.getId());
            entityManager.remove(o);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
           entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void removeById(Integer id) throws SQLException {
        try {
            Users users = getById(id);
            remove(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
