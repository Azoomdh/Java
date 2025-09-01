package com.example.demoJava4.HoaDonNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class HoaDonNhapService 
    implements ServiceInterface<HoaDonNhap, Long>
{
    @Autowired
    private HoaDonNhapRepo hoaDonNhapRepo;

    @Override
    public HoaDonNhap findById(Long tKey) {
        return this.hoaDonNhapRepo.findById(tKey);
    }

    @Override
    public List<HoaDonNhap> getList(Integer sttPage, Integer sizePage) {
        return this.hoaDonNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public HoaDonNhap create(HoaDonNhap t) {
        return this.hoaDonNhapRepo.create(t);
    }

    @Override
    public HoaDonNhap update(Long tKey, HoaDonNhap t) {
        return this.hoaDonNhapRepo.create(t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.hoaDonNhapRepo.delete(tKey);
    }


    
}
