/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author XC
 */
public class ConnectionJDBC {
    private Connection c = null;
    private String user;
    private String pass;
    public String url = "jdbc:postgresql://localhost:5432/bazaDB";
    
    public ConnectionJDBC(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    public ConnectionJDBC(){};
    
    public void ConnectionPostgres(String user, String pass, String url) throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(this.url,this.user,this.pass);
            
            System.out.println("Connected! - from: class.ConnectionJDBC");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CloseConnectionPostgres() throws SQLException{
    c.close();
    }
    
    
    
    
    
}
