/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.dao;

import java.sql.SQLException;

/**
 *
 * @author damian
 */
public interface DAO <T, ID> {
    boolean save(T o) throws SQLException;
    
}
