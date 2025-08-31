package com.example.demoJava3.Interface;

import org.springframework.data.domain.Page;

public interface ServiceInterface<T, TKey> {

    public T getById(TKey tId);

    public Page<T> getList(Integer sttPage, Integer sizePage);

    public T update(TKey tId, T t2);

    public T create(T t2);

    public Boolean delete(TKey tId);
}
