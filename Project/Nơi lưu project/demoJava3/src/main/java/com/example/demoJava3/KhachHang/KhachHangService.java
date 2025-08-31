package com.example.demoJava3.KhachHang;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demoJava3.Interface.ServiceInterface;
import com.example.demoJava3.User.UsersService;

@Service
public class KhachHangService
    implements ServiceInterface<KhachHang, Long>
{

    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    UsersService usersService;

    @Override
    public KhachHang getById(Long tId) {
        Optional<KhachHang> optKh1= this.khachHangRepo.findById(tId);
        
        if(optKh1.isPresent()==false){
            return null;
        }
        else {
            return optKh1.get();
        }
    }

    @Override
    public Page<KhachHang> getList(Integer sttPage, Integer sizePage) {
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);
        
        return this.khachHangRepo.findAll(pageable1);
    }

    @Override
    public KhachHang create(KhachHang t2) {
        t2 = this.khachHangRepo.save(t2);
        return t2;
    }

    @Override
    public KhachHang update(Long tId, KhachHang t2) {
        KhachHang kh1 = this.getById(tId);

        if(kh1==null){
            return null;
        }
        else {
            kh1.updateNotId(t2);
            kh1 = this.khachHangRepo.save(kh1);
            return kh1;
        }
    }

    @Override
    public Boolean delete(Long tId) {
        Boolean isSuccess = null;

        KhachHang kh1 = this.getById(tId);

        if(kh1== null){
            isSuccess = false;
            return isSuccess;
        }
        else {
            this.khachHangRepo.delete(kh1);
            isSuccess = true;
            return isSuccess;
        }
    }

    
}
