/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import pl.dbabinski.jdbc.entity.Users;

/**
 *
 * @author damian
 */
public class TableModelUsers extends AbstractTableModel{
    
    @SuppressWarnings("unchecked")
    public static DefaultTableModel getDefaultTableModel(List<Users> list) {
        Vector titles = new Vector();
        titles.add("id");
        titles.add("kategorie");
        titles.add("imie");
        titles.add("nazwisko");
        titles.add("login");
        titles.add("haslo");
        Vector rows = new Vector(list != null ? list.size() : 0);
        if (list != null) {
            for (Users l : list) {
                rows.add(getVector(l));
            }
        }
        return new DefaultTableModel(rows, titles);
    }

    @SuppressWarnings("unchecked")
    public static Vector getVector(Users object) {
        Vector vector = new Vector();
        vector.add(object.getId());
        vector.add(object.getIdUserCategory().getUserCategory());
        vector.add(object.getUserName());
        vector.add(object.getUserLastname());
        vector.add(object.getLogin());
        vector.add(object.getPassword());
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
