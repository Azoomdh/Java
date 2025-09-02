package com.example.demoJava4.Interface;

import java.util.List;

public interface ControllerInterface<T, TKey> {

    public String findById(TKey tKey);

    public String getList(Integer sttPage, Integer sizePage);

    public String create(T t);

    public String update(TKey tKey, T t);

    public String delete(TKey tKey);
}
