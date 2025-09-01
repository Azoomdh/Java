package com.example.demoJava4.DsspBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class DsspBanService
    implements ServiceInterface<DsspBan, DsspBanKey>
{

    @Autowired
    private DsspBanRepo dsspBanRepo;

    @Override
    public DsspBan findById(DsspBanKey tKey) {
        return this.dsspBanRepo.findById(tKey);
    }

    @Override
    public List<DsspBan> getList(Integer sttPage, Integer sizePage) {
        return this.dsspBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public DsspBan create(DsspBan t) {
        // không được set null
        
        return this.dsspBanRepo.create(t);
    }

    @Override
    public DsspBan update(DsspBanKey tKey, DsspBan t) {
        DsspBan dsspBan1 = this.findById(tKey);

        if(dsspBan1==null){
            return null;
        }
        return this.dsspBanRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(DsspBanKey tKey) {
        return this.dsspBanRepo.delete(tKey);
    }

}
