package com.example.demoJava4.CuaHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class CuaHangService 
    implements ServiceInterface<CuaHang, Long>
{

    @Autowired
    private CuaHangRepo cuaHangRepo;

    @Override
    public CuaHang findById(Long tKey) {
        return this.cuaHangRepo.findById(tKey);
    }

    @Override
    public List<CuaHang> getList(Integer sttPage, Integer sizePage) {
        return this.cuaHangRepo.getList(sttPage, sizePage);
    }

    @Override
    public CuaHang create(CuaHang t) {
        t.setId(null);

        return this.cuaHangRepo.create(t);
    }

    @Override
    public CuaHang update(Long tKey, CuaHang t) {
        CuaHang cuaHang1 = this.findById(tKey);

        if(cuaHang1==null){
            return null;
        }
        return this.cuaHangRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        
        return this.cuaHangRepo.delete(tKey);
    }

}
