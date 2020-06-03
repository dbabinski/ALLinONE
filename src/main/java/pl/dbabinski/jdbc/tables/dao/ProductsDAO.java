/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.dbabinski.jdbc.entity.Products;
import pl.dbabinski.jdbc.tables.TableModelProducts;

/**
 *
 * @author damian
 */
public class ProductsDAO implements I_ProductsDAO{
    private static TableModelProducts instance;
    
    public static TableModelProducts getInstance(){
        if (instance == null){
        instance = new TableModelProducts();
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
    
    public Products getById(final int id){
        return entityManager.find(Products.class, id);
    }
    
    public List<Products> findAll() {
        return entityManager.createNamedQuery("Products.findAll").getResultList();
    }

    @Override
    public boolean save(Products o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
