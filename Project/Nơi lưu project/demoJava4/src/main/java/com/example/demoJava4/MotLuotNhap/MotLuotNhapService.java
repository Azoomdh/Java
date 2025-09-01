package com.example.demoJava4.MotLuotNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class MotLuotNhapService 
    implements ServiceInterface<MotLuotNhap, Long>
{

    @Autowired
    private MotLuotNhapRepo motLuotNhapRepo;

    @Override
    public MotLuotNhap findById(Long tKey) {
        return this.motLuotNhapRepo.findById(tKey);
    }

    @Override
    public List<MotLuotNhap> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public MotLuotNhap create(MotLuotNhap t) {
        return this.motLuotNhapRepo.create(t);
    }

    @Override
    public MotLuotNhap update(Long tKey, MotLuotNhap t) {
        return this.motLuotNhapRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.motLuotNhapRepo.delete(tKey);
    }

    
}
