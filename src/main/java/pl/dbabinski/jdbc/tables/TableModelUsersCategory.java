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
import pl.dbabinski.jdbc.entity.UsersCategory;

/**
 *
 * @author damian
 */
public class TableModelUsersCategory extends AbstractTableModel{
//    private static TableModelUsersCategory instance;
//    public static TableModelUsersCategory getInstance(){
//        if (instance == null){
//        instance = new TableModelUsersCategory();
//        }
//                
//        return instance;
//    };
//    
//    public EntityManager entityManager;
//    
//    public EntityManager getEntityManager() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pl.dbabinski.persistance-office");
//        if(entityManager == null) {
//            entityManager = factory.createEntityManager();
//        }
//        
//        return entityManager;   
//    }
    
    
     @SuppressWarnings("unchecked")
    public static DefaultTableModel getDefaultTableModel(List<UsersCategory> list) {
        Vector titles = new Vector();
        titles.add("Id");
        titles.add("Kategorie");
        Vector rows = new Vector(list != null ? list.size() : 0);
        if (list != null) {
            for (UsersCategory l : list) {
                rows.add(getVector(l));
            }
        }
        return new DefaultTableModel(rows, titles);
    }

    @SuppressWarnings("unchecked")
    public static Vector getVector(UsersCategory object) {
        Vector vector = new Vector();
        vector.add(object.getId());
        vector.add(object.getUserCategory());
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
