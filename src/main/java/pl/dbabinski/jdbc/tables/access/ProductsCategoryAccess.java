/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.access;

import java.sql.SQLException;
import java.util.List;
import pl.dbabinski.jdbc.entity.ProductCategory;
import pl.dbabinski.jdbc.entitymanager.MyEntityManager;
import pl.dbabinski.jdbc.tables.TableModelProductCategory;

/**
 *
 * @author XC
 */
public class ProductsCategoryAccess extends MyEntityManager implements I_ProductsCategoryAccess{
    
    private static TableModelProductCategory instance;
    public static TableModelProductCategory getInstance(){
        if (instance == null){
        instance = new TableModelProductCategory();
        }
                
        return instance;
    };
    
    
    public ProductCategory getById(final int id){
        return entityManager.find(ProductCategory.class, id);
    }
    
    
    @Override
    public List<ProductCategory> findAll() {
        return entityManager.createNamedQuery("ProductCategory.findAll").getResultList();
    }

    @Override
    public void persist(ProductCategory o) throws SQLException {
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
    public void merge(ProductCategory o) throws SQLException {
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
    public void remove(ProductCategory o) throws SQLException {
         try {
            entityManager.getTransaction().begin();
            o = entityManager.find(ProductCategory.class, o.getId());
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
            ProductCategory productCategory = getById(id);
            remove(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
