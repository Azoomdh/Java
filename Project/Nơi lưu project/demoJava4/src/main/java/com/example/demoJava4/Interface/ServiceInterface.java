package com.example.demoJava4.Interface;

import java.util.List;

public interface ServiceInterface <T, TKey>
{

    public T findById(TKey tKey);

    public List<T> getList(Integer sttPage, Integer sizePage);

    public T create(T t);

    public T update(TKey tKey, T t);

    public Boolean delete(TKey tKey);

    // những thứ dùng hàm này thì tKey không phải null
    public Boolean checkPkTonTai(TKey tKey);

    // những thứ dùng hàm này thì tKey có thể null
    public Boolean checkFkTonTai(T t);

    // những thứ dùng hàm này chắc chắn tKey không phải null
    public Boolean checkKeyTonTai(TKey tKey);

}
