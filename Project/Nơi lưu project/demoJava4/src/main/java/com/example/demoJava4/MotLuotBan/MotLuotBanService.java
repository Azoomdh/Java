package com.example.demoJava4.MotLuotBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class MotLuotBanService 
    implements ServiceInterface<MotLuotBan, Long>
{
    @Autowired
    private MotLuotBanRepo motLuotBanRepo;

    @Override
    public MotLuotBan findById(Long tKey) {
        return this.motLuotBanRepo.findById(tKey);
    }

    @Override
    public List<MotLuotBan> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public MotLuotBan create(MotLuotBan t) {
        return this.motLuotBanRepo.create(t);
    }

    @Override
    public MotLuotBan update(Long tKey, MotLuotBan t) {
        return this.motLuotBanRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.motLuotBanRepo.delete(tKey);
    }
    
}
