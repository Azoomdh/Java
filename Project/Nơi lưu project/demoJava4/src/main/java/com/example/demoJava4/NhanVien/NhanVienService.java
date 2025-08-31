package com.example.demoJava4.NhanVien;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class NhanVienService 
    implements ServiceInterface<NhanVien, Long>
{

    @Autowired
    private NhanVienRepo nvRepo;

    @Override
    public NhanVien findById(Long tKey) {
        return this.nvRepo.findById(tKey);
    }

    @Override
    public List<NhanVien> getList(Integer sttPage, Integer sizePage) {
        return this.nvRepo.getList(sttPage, sizePage);
    }

    @Override
    public NhanVien create(NhanVien t) {
        // PK của NhanVien là FK nên không được set null

        // NhanVien nv1 = this.findById(t.getUserId());        
        // // nếu t đã tồn tại thì không create
        // if(nv1 != null){
        //     return nv1;
        // }

        return this.nvRepo.create(t);
    }

    @Override
    public NhanVien update(Long tKey, NhanVien t) {
        
        NhanVien nv1 = this.findById(tKey);

        // nếu không tồn tại thì không update
        if(nv1==null){
            return null;
        }

        return this.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.nvRepo.delete(tKey);
    }
    
}
