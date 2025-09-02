package com.example.demoJava4.KhachHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.User.UserService;

@Service
public class KhachHangService 
    implements ServiceInterface<KhachHang, Long>
{

    @Autowired
    private KhachHangRepo khRepo;

    @Autowired
    private UserService userService;

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

        // dù chỉ 1 FK của thực thể này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        // thực thể này đã tồn tại trong bảng thì return null;
        // nếu thực thể yếu đã tồn tại thì return null
        if(this.findById(t.getUserId())!=null){
            return null;
        }

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

        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.khRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(KhachHang t) {

        if(this.userService.checkKeyTonTai(t.getUserId())== false){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        KhachHang t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        KhachHang t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    
}
