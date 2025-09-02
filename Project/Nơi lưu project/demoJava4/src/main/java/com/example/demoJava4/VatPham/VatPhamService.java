package com.example.demoJava4.VatPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class VatPhamService 
    implements ServiceInterface<VatPham, Long>
{

    @Autowired
    private VatPhamRepo vatPhamRepo;

    @Override
    public VatPham findById(Long tKey) {
        return this.vatPhamRepo.findById(tKey);
    }

    @Override
    public List<VatPham> getList(Integer sttPage, Integer sizePage) {
        return this.vatPhamRepo.getList(sttPage, sizePage);
    }

    @Override
    public VatPham create(VatPham t) {
        t.setId(null);

        // dù chỉ 1 FK của thực thể này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        return this.vatPhamRepo.create(t);
    }

    @Override
    public VatPham update(Long tKey, VatPham t) {
        return this.vatPhamRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {

        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.vatPhamRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(VatPham t) {
        // vat phẩm không có Fk
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        VatPham t = this.findById(tKey);

        if(t==null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        VatPham t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
