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

        if(this.checkFkTonTai(t)== false){
            return null;
        }

        return this.cuaHangRepo.create(t);
    }

    @Override
    public CuaHang update(Long tKey, CuaHang t) {
        t.setId(tKey);

        if(this.checkFkTonTai(t)== false || this.checkPkTonTai(tKey)==false){
            return null;
        }
        return this.cuaHangRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {

        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.cuaHangRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(CuaHang t) {
        // cuahang không có FK
        return true;
    }


    @Override
    public Boolean checkPkTonTai(Long tKey) {
        CuaHang t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        CuaHang t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
