package com.example.demoJava4.Interface;

import java.util.List;

public interface ServiceInterface <T, TKey>
{

    public T findById(TKey tKey);

    public List<T> getList(Integer sttPage, Integer sizePage);

    public T create(T t);

    public T update(TKey tKey, T t);

    public Boolean delete(TKey tKey);

    // public Boolean checkDaTonTai(T t);

    // public Boolean checkHopLe(T t);
}
