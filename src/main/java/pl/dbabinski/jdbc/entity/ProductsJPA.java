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
public class ProductsJPA {
    private static ProductsJPA instance;
    public static ProductsJPA getInstance(){
        if (instance == null){
        instance = new ProductsJPA();
        }
                
        return instance;
    };
    
    protected EntityManager entityManager;
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pl.dbabinski.persistance-office");
        if(entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;   
    }
    
    public Products getById(final int id){
        return entityManager.find(Products.class, id);
    }
    
    public List<Products> findAll() {
        return entityManager.createNamedQuery("Products.findAll").getResultList();
    }
    
    public void persist(Products products){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(products);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge (Products products) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(products);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove (Products products) {
        try {
            entityManager.getTransaction().begin();
            products = entityManager.find(Products.class, products.getId());
            entityManager.remove(products);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
           entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById (final int id) {
        try {
            Products products = getById(id);
            remove(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
