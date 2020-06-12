/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.tables.access;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author damian
 */
public interface Access <T, ID> {
    List<T> findAll();
    void persist(T o) throws SQLException;
    void merge(T o) throws SQLException;
    void remove(T o) throws SQLException;
    void removeById(Integer id) throws SQLException;
}
