/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables;

import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import pl.dbabinski.jdbc.entity.ProductCategory;


/**
 *
 * @author damian
 */
public class TableModelProductCategory extends AbstractTableModel {
    
    
    
    @SuppressWarnings("unchecked")
    public static DefaultTableModel getDefaultTableModel(List<ProductCategory> list) {
        Vector titles = new Vector();
        titles.add("Id");
        titles.add("kategorie");
        Vector rows = new Vector(list != null ? list.size() : 0);
        if (list != null) {
            for (ProductCategory l : list) {
                rows.add(getVector(l));
            }
        }
        return new DefaultTableModel(rows, titles);
    }

    @SuppressWarnings("unchecked")
    public static Vector getVector(ProductCategory object) {
        Vector vector = new Vector();
        vector.add(object.getId());
        vector.add(object.getProductCategory());
        return vector;
    }
    
    private static TableModelProductCategory instance;
    
    public static TableModelProductCategory getInstance(){
        if (instance == null){
        instance = new TableModelProductCategory();
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
            

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        ProductCategory r = (ProductCategory) dane.get(rowIndex);
//        switch(columnIndex){
//            case 0:
//                    return r.getId();
//            case 1: 
//                    return r.getProductCategory();
//            case 2:
//        }
        return null;
    }
}
