package com.example.demoJava4.HoaDonBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class HoaDonBanService 
    implements ServiceInterface<HoaDonBan, Long>
{

    @Autowired
    private HoaDonBanRepo hoaDonBanRepo;

    @Override
    public HoaDonBan findById(Long tKey) {
        return this.hoaDonBanRepo.findById(tKey);
    }

    @Override
    public List<HoaDonBan> getList(Integer sttPage, Integer sizePage) {
        return this.hoaDonBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public HoaDonBan create(HoaDonBan t) {
        return this.hoaDonBanRepo.create(t);
    }

    @Override
    public HoaDonBan update(Long tKey, HoaDonBan t) {
        HoaDonBan hoaDonBan1 = this.findById(tKey);
        return null;
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.hoaDonBanRepo.delete(tKey);
    }
    
}
