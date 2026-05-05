package com.example.demoJava6.HoaDonBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class HoaDonBanService 
    implements ServiceInterface<HoaDonBan, Long>
{

    @Autowired
    private HoaDonBanRepo hoaDonBanRepo;

    @Override
    public HoaDonBan findById(Long id) {
        return this.hoaDonBanRepo.findById(id);
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
    public HoaDonBan update(Long id, HoaDonBan t) {
        return this.hoaDonBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.hoaDonBanRepo.delete(id);
    }
    
}
