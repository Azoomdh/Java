package com.example.demoJava6.Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RepoInterface <T, Id> {
    
    public Connection getConnection() throws SQLException;
    
    public T getFromResultSet(ResultSet rs);
    
    public T findById(Id id);
    
    public List<T> getList(Integer sttPage, Integer sizePage);
    
    public T create(T t);
    
    public T update(Id id, T t);
    
    public Boolean delete(Id id);
}