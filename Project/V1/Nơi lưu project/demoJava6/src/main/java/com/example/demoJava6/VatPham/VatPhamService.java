package com.example.demoJava6.VatPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class VatPhamService 
    implements ServiceInterface<VatPham, Long>
{
    @Autowired
    private VatPhamRepo vatPhamRepo;

    @Override
    public VatPham findById(Long id) {
        return this.vatPhamRepo.findById(id);
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
    public VatPham update(Long id, VatPham t) {
        return this.vatPhamRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.vatPhamRepo.delete(id);
    }
}
