package com.example.demoJava4.DsspBan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.MotLuotBan.MotLuotBanService;
import com.example.demoJava4.VatPham.VatPhamService;

@Service
public class DsspBanService
    implements ServiceInterface<DsspBan, DsspBanKey>
{

    @Autowired
    private DsspBanRepo dsspBanRepo;
    
    @Autowired
    private VatPhamService vatPhamService;

    @Autowired
    private MotLuotBanService motLuotBanService;

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
        // không được set null id
        
        // dù chỉ 1 FK của thực thể này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        // thực thể này đã tồn tại thì return null 
        // nếu thực thể yếu đã tồn tại thì return null
        if(this.findById(t.getDsspBanKey())!= null){
            return null;
        }

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
        
        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.dsspBanRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(DsspBan t) {
        if(this.vatPhamService.checkKeyTonTai(t.getDsspBanKey().getVatPhamid())== false){
            return false;
        }
        if(this.motLuotBanService.checkKeyTonTai(t.getDsspBanKey().getMotLuotBanid())== false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(DsspBanKey tkey) {
        DsspBan t = this.findById(tkey);
        
        if(t==null){
            return false;
        }

        return true;
    }

    @Override
    public Boolean checkKeyTonTai(DsspBanKey tKey) {
        DsspBan t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
