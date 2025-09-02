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
        t.setId(null);

        // dù chỉ 1 FK của thực thể này không tồn tại thì return null; 
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        return this.hoaDonBanRepo.create(t);
    }

    @Override
    public HoaDonBan update(Long tKey, HoaDonBan t) {
        
        // dù chỉ 1 FK không tồn tại thì return null
        if(this.checkFkTonTai(t)== false){
            return null;
        }
        // thực thể này không tồn tại thì return null
        if(this.checkPkTonTai(tKey)==false){
            return null;
        }

        return this.hoaDonBanRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {

        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

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
