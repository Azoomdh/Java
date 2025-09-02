package com.example.demoJava4.HoaDonBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.MotLuotBan.MotLuotBanService;

@Service
public class HoaDonBanService 
    implements ServiceInterface<HoaDonBan, Long>
{

    @Autowired
    private HoaDonBanRepo hoaDonBanRepo;

    @Autowired
    private MotLuotBanService motLuotBanService;

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

    @Override
    public Boolean checkFkTonTai(HoaDonBan t) {
        if(this.motLuotBanService.checkKeyTonTai(t.getMotLuotBanid())==false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        HoaDonBan t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        HoaDonBan t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }
    
    
}
