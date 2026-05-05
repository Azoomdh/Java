/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap1.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author azoom
 */
public interface RepoInterface <T, Id> {
    
    public Connection getConnection() throws SQLException;
    
    public T getFromResultSet(ResultSet rs);
    
    public T findById(Id id);
    
    public List<T> getList();
    
    public T create(T t);
    
    public T update(Id id, T t);
    
    public Boolean delete(Id id);
}
