package com.example.demoJava4.DsspNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demoJava4.Interface.ServiceInterface;

public class DsspNhapService 
    implements ServiceInterface<DsspNhap, DsspNhapKey>
{

    @Autowired
    private DsspNhapRepo dsspNhapRepo;
    
    @Override
    public DsspNhap findById(DsspNhapKey tKey) {
        return this.dsspNhapRepo.findById(tKey);
    }

    @Override
    public List<DsspNhap> getList(Integer sttPage, Integer sizePage) {
        return this.dsspNhapRepo.getList(sttPage, sizePage);
    }
    
    @Override
    public DsspNhap create(DsspNhap t) {
        return this.dsspNhapRepo.create(t);
    }
    
    @Override
    public DsspNhap update(DsspNhapKey tKey, DsspNhap t) {
        DsspNhap dsspNhap1 = this.findById(tKey);

        if(dsspNhap1!= null){
            return null;
        }

        return this.dsspNhapRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(DsspNhapKey tKey) {
        return this.dsspNhapRepo.delete(tKey);
    }
    
}
