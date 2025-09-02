package com.example.demoJava4.MotLuotNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.CuaHang.CuaHangService;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.NhaCungCap.NhaCungCapService;
import com.example.demoJava4.NhanVien.NhanVienService;

@Service
public class MotLuotNhapService 
    implements ServiceInterface<MotLuotNhap, Long>
{

    @Autowired
    private MotLuotNhapRepo motLuotNhapRepo;

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @Override
    public MotLuotNhap findById(Long tKey) {
        return this.motLuotNhapRepo.findById(tKey);
    }

    @Override
    public List<MotLuotNhap> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public MotLuotNhap create(MotLuotNhap t) {
        t.setId(null);
        
        // dù chỉ 1 FK của thực thể này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }
        return this.motLuotNhapRepo.create(t);
    }

    @Override
    public MotLuotNhap update(Long tKey, MotLuotNhap t) {
        return this.motLuotNhapRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {

        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.motLuotNhapRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(MotLuotNhap t) {
        if(this.nhaCungCapService.checkKeyTonTai(t.getNhaCungCapid())==false ){
            return false;
        }
        if(this.cuaHangService.checkKeyTonTai(t.getCuaHangid())==false ){
            return false;
        }
        if(this.nhanVienService.checkKeyTonTai(t.getNhanVienUserid())==false ){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        MotLuotNhap t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        MotLuotNhap t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
