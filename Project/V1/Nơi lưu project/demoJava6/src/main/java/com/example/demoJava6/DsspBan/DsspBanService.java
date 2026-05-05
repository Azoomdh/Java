package com.example.demoJava6.DsspBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class DsspBanService 
    implements ServiceInterface<DsspBan, DsspBanId>
{

    @Autowired
    private DsspBanRepo dsspBanRepo;

    @Override
    public DsspBan findById(DsspBanId id) {
        return this.dsspBanRepo.findById(id);
    }

    @Override
    public List<DsspBan> getList(Integer sttPage, Integer sizePage) {
        return this.dsspBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public DsspBan create(DsspBan t) {
        return this.dsspBanRepo.create(t);
    }
    
    @Override
    public DsspBan update(DsspBanId id, DsspBan t) {
        t.setId(id);
        return this.dsspBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(DsspBanId id) {
        return this.dsspBanRepo.delete(id);
    }

    
}
