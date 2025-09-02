package com.example.demoJava3.NhanVien;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demoJava3.Interface.ServiceInterface;
import com.example.demoJava3.KhachHang.KhachHang;
import com.example.demoJava3.User.UsersService;

@Service
public class NhanVienService 
    implements ServiceInterface<NhanVien, Long>
{
    @Autowired
    NhanVienRepo nhanVienRepo;

    @Autowired
    UsersService usersService;

    @Override
    public NhanVien getById(Long tId) {
        Optional<NhanVien> optNv1 = this.nhanVienRepo.findById(tId);

        if(optNv1.isPresent()== false){
            return null;
        }
        else {
            return optNv1.get();
        }
    }

    @Override
    public Page<NhanVien> getList(Integer sttPage, Integer sizePage) {
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return this.nhanVienRepo.findAll(pageable1);
    }

    @Override
    public NhanVien create(NhanVien t2) {
        t2 = this.nhanVienRepo.save(t2);
        return t2;
    }
    
    @Override
    public NhanVien update(Long tId, NhanVien t2) {
        NhanVien nv1 = this.getById(tId);
        if(nv1==null){
            return null;
        }
        else{
            nv1.updateNotId(t2);
            nv1= this.nhanVienRepo.save(nv1);
            return nv1;
        }
    }

    @Override
    public Boolean delete(Long tId) {
        Boolean isSuccess = null;

        NhanVien nv1 = this.getById(tId);

        if(nv1== null){
            isSuccess = false;
            return isSuccess;
        }
        else {
            this.nhanVienRepo.delete(nv1);
            isSuccess = true;
            return isSuccess;
        }
    }

    
}
