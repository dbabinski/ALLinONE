/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.access;

import pl.dbabinski.jdbc.entitymanager.MyEntityManager;
import java.sql.SQLException;
import java.util.List;
import pl.dbabinski.jdbc.entity.Products;

/**
 *
 * @author damian
 */
public class ProductsAccess extends MyEntityManager implements I_ProductsAccess {
    private static Products instance;
    
    public static Products getInstance(){
        if (instance == null){
        instance = new Products();
        }
                
        return instance;
    };
        
    public Products getById(final int id){
        return entityManager.find(Products.class, id);
    }

    @Override
    public List<Products> findAll() {
        return entityManager.createNamedQuery("Products.findAll").getResultList();
    }

    @Override
    public void persist(Products o) throws SQLException {
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
    public void merge(Products o) throws SQLException {
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
    public void remove(Products o) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            o = entityManager.find(Products.class, o.getId());
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
            Products products = getById(id);
            remove(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
