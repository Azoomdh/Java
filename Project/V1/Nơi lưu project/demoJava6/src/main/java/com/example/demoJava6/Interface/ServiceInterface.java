package com.example.demoJava6.Interface;

import java.util.List;

public interface ServiceInterface <T, Id> {

    public T findById(Id id);

    public List<T> getList(Integer sttPage, Integer sizePage);

    public T create(T t);

    public T update(Id id, T t);

    public Boolean delete(Id id);

}
