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
public class ProductCategoryJPA {
    
    private static ProductCategoryJPA instance;
    public static ProductCategoryJPA getInstance(){
        if (instance == null){
        instance = new ProductCategoryJPA();
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
    
    public ProductCategory getById(final int id){
        return entityManager.find(ProductCategory.class, id);
    }
    
    public List<ProductCategory> findAll() {
        return entityManager.createNamedQuery("ProductCategory.findAll").getResultList();
    }
    
    public void persist(ProductCategory productCategory){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(productCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge (ProductCategory productCategory) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(productCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove (ProductCategory productCategory) {
        try {
            entityManager.getTransaction().begin();
            productCategory = entityManager.find(ProductCategory.class, productCategory.getId());
            entityManager.remove(productCategory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
           entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById (final int id) {
        try {
            ProductCategory productCategory = getById(id);
            remove(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
