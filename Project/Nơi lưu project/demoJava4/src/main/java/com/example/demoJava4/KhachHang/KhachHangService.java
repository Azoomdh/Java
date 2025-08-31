package com.example.demoJava4.KhachHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class KhachHangService 
    implements ServiceInterface<KhachHang, Long>
{

    @Autowired
    private KhachHangRepo khRepo;

    @Override
    public KhachHang findById(Long tKey) {
        return this.khRepo.findById(tKey);
    }

    @Override
    public List<KhachHang> getList(Integer sttPage, Integer sizePage) {
        return this.khRepo.getList(sttPage, sizePage);
    }

    @Override
    public KhachHang create(KhachHang t) {
        // PK của khachhang là FK nên không được set null

        // KhachHang kh1 = this.findById(t.getUserId());
        // // nếu đã tồn tại thì không create
        // if(kh1 != null){
        //     return null;
        // }

        return this.khRepo.create(t);
    }

    @Override
    public KhachHang update(Long tKey, KhachHang t) {

        KhachHang kh1 = this.findById(tKey);

        // nếu không tồn tại thì không update
        if(kh1 == null){
            return null;
        }

        return this.khRepo.update(tKey, t);
    }


    @Override
    public Boolean delete(Long tKey) {
        return this.khRepo.delete(tKey);
    }

    
}
