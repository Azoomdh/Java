package com.example.demoJava4.MotLuotBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHangService;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.KhachHang.KhachHangService;
import com.example.demoJava4.NhanVien.NhanVienService;

@Service
public class MotLuotBanService 
    implements ServiceInterface<MotLuotBan, Long>
{
    @Autowired
    private MotLuotBanRepo motLuotBanRepo;

    @Autowired 
    private KhachHangService khachHangService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private NhanVienService nhanVienService;

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

    @Override
    public Boolean checkFkTonTai(MotLuotBan t) {
        if(this.khachHangService.checkKeyTonTai(t.getKhachHangUserid())==false){
            return false;
        }
        if(this.cuaHangService.checkKeyTonTai(t.getCuaHangid())==false){
            return false;
        }
        if(this.nhanVienService.checkKeyTonTai(t.getNhanVienUserid())==false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        MotLuotBan t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        MotLuotBan t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }
    
    
}
