package com.example.demoJava6.MotLuotBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class MotLuotBanService 
    implements ServiceInterface<MotLuotBan, Long>
{

    @Autowired
    private MotLuotBanRepo motLuotBanRepo;

    @Override
    public MotLuotBan findById(Long id) {
        return this.motLuotBanRepo.findById(id);
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
    public MotLuotBan update(Long id, MotLuotBan t) {
        return this.motLuotBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.motLuotBanRepo.delete(id);
    }
}
