package com.example.demoJava4.NhaCungCap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class NhaCungCapService 
    implements ServiceInterface<NhaCungCap, Long>
{

    @Autowired
    private NhaCungCapRepo nhaCungCapRepo;

    @Override
    public NhaCungCap findById(Long tKey) {
        return this.nhaCungCapRepo.findById(tKey);
    }

    @Override
    public List<NhaCungCap> getList(Integer sttPage, Integer sizePage) {
        return this.nhaCungCapRepo.getList(sttPage, sizePage);
    }

    @Override
    public NhaCungCap create(NhaCungCap t) {
        return this.nhaCungCapRepo.create(t);
    }

    @Override
    public NhaCungCap update(Long tKey, NhaCungCap t) {
        return this.nhaCungCapRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.nhaCungCapRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(NhaCungCap t) {
        // NhaCungCap không có FK
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tkey) {
        NhaCungCap t = this.findById(tkey);
        
        if(t==null){
            return false;
        }

        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        NhaCungCap t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
