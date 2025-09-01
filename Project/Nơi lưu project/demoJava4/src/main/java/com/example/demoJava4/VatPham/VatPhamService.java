package com.example.demoJava4.VatPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.vatPhamRepo.create(t);
    }

    @Override
    public VatPham update(Long tKey, VatPham t) {
        return this.vatPhamRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.vatPhamRepo.delete(tKey);
    }

    
}
