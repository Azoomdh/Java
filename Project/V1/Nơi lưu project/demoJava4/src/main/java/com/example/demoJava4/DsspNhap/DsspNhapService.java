package com.example.demoJava4.DsspNhap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.MotLuotNhap.MotLuotNhapService;
import com.example.demoJava4.VatPham.VatPhamService;

public class DsspNhapService 
    implements ServiceInterface<DsspNhap, DsspNhapKey>
{

    @Autowired
    private DsspNhapRepo dsspNhapRepo;

    @Autowired
    private MotLuotNhapService motLuotNhapService;

    @Autowired
    private VatPhamService vatPhamService;
    
    @Override
    public DsspNhap findById(DsspNhapKey tKey) {
        return this.dsspNhapRepo.findById(tKey);
    }

    @Override
    public List<DsspNhap> getList(Integer sttPage, Integer sizePage) {
        return this.dsspNhapRepo.getList(sttPage, sizePage);
    }
    
    @Override
    public DsspNhap create(DsspNhap t) {
        // không được set null id

        // dù chỉ 1 FK của cái này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        // thực thể này đã tồn tại thì return null;
        // nếu thực thể yếu đã tồn tại thì return null
        if(this.findById(t.getDsspNhapKey())!=null ){
            return null;
        }

        return this.dsspNhapRepo.create(t);
    }
    
    @Override
    public DsspNhap update(DsspNhapKey tKey, DsspNhap t) {
        // dù chỉ 1 FK không tồn tại thì return null
        if(this.checkFkTonTai(t)== false){
            return null;
        }
        // thực thể này không tồn tại thì return null
        if(this.checkPkTonTai(tKey)==false){
            return null;
        }

        return this.dsspNhapRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(DsspNhapKey tKey) {
        
        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.dsspNhapRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(DsspNhap t) {
        if(this.motLuotNhapService.checkKeyTonTai(t.getDsspNhapKey().getMotLuotNhapid())==false){
            return false;
        }
        if(this.vatPhamService.checkKeyTonTai(t.getDsspNhapKey().getVatPhamid())==false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(DsspNhapKey tKey) {
        DsspNhap t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(DsspNhapKey tKey) {
        DsspNhap t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }
    
}
