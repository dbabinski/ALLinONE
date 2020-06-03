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
import pl.dbabinski.jdbc.entity.Products;


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
        vector.add(object.getIdProductCategory().getProductCategory());
        vector.add(object.getProductName());
        vector.add(object.getProductAutorName());
        vector.add(object.getProductAutorLastname());
        vector.add(object.getProductCountryName());
        vector.add(object.getProductCost());
        return vector;
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
