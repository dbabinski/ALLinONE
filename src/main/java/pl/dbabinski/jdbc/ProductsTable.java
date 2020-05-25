/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc;
import java.util.List;
import javax.swing.table.*;
import pl.dbabinski.jdbc.jpa.Products;


/**
 *
 * @author XC
 */
public class ProductsTable extends AbstractTableModel{
    
    private List<Products> productsList = null;
    private  String[] columns = {"id","kategorie","nazwa produktu","imie autora","nazwisko autora","kraj","cena"};
    
    public ProductsTable(){}

    @Override
    public int getRowCount() {
        return 0;
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
