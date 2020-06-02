/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.entity;

import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author damian
 */
public class TableModelProducts extends AbstractTableModel{
    
    
    @SuppressWarnings("unchecked")
    public static DefaultTableModel getDefaultTableModel(List<Products> list) {
        Vector titles = new Vector();
        titles.add("Id");
        titles.add("kategorie");
        titles.add("nazwa");
        titles.add("imie autora");
        titles.add("nazwisko autora");
        titles.add("kraj");
        titles.add("cena");
        Vector rows = new Vector(list != null ? list.size() : 0);
        if (list != null) {
            for (Products l : list) {
                rows.add(getVector(l));
            }
        }
        return new DefaultTableModel(rows, titles);
    }

    @SuppressWarnings("unchecked")
    public static Vector getVector(Products object) {
        Vector vector = new Vector();
        vector.add(object.getId());
        vector.add(object.getIdProductCategory());
        vector.add(object.getProductName());
        vector.add(object.getProductAutorName());
        vector.add(object.getProductAutorLastname());
        vector.add(object.getProductCountryName());
        vector.add(object.getProductCost());
        return vector;
    }
    
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
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
