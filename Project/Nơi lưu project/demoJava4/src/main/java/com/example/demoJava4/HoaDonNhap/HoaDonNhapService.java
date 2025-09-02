package com.example.demoJava4.HoaDonNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.MotLuotNhap.MotLuotNhapService;

@Service
public class HoaDonNhapService 
    implements ServiceInterface<HoaDonNhap, Long>
{
    @Autowired
    private HoaDonNhapRepo hoaDonNhapRepo;

    @Autowired
    private MotLuotNhapService motLuotNhapService;

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

    @Override
    public Boolean checkFkTonTai(HoaDonNhap t) {
        if(this.motLuotNhapService.checkKeyTonTai(t.getMotLuotNhapid())==false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        HoaDonNhap t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        HoaDonNhap t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }
    
}
