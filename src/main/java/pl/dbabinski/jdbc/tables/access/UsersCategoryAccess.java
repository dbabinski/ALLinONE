/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.access;

import pl.dbabinski.jdbc.entitymanager.MyEntityManager;
import java.sql.SQLException;
import java.util.List;
import pl.dbabinski.jdbc.entity.UsersCategory;
import pl.dbabinski.jdbc.tables.TableModelUsersCategory;


/**
 *
 * @author XC
 */
public class UsersCategoryAccess extends  MyEntityManager implements I_UsersCategoryAccess{
    
    private static TableModelUsersCategory instance;
    public static TableModelUsersCategory getInstance(){
        if (instance == null){
        instance = new TableModelUsersCategory();
        }
                
        return instance;
    };
    
    public UsersCategory getById(final int id){
        return entityManager.find(UsersCategory.class, id);
    }
    
    @Override
    public List<UsersCategory> findAll() {
        return entityManager.createNamedQuery("UsersCategory.findAll").getResultList();
    }

    @Override
    public void persist(UsersCategory o) throws SQLException {
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
    public void merge(UsersCategory o) throws SQLException {
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
    public void remove(UsersCategory o) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            o = entityManager.find(UsersCategory.class, o.getId());
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
            UsersCategory users = getById(id);
            remove(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
