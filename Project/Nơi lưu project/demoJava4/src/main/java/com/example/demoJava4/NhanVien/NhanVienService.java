package com.example.demoJava4.NhanVien;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;
import com.example.demoJava4.User.UserService;

@Service
public class NhanVienService 
    implements ServiceInterface<NhanVien, Long>
{

    @Autowired
    private NhanVienRepo nvRepo;

    @Autowired
    private UserService userService;

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

        // dù chỉ 1 FK của thực thể này không tồn tại thì return null;
        if(this.checkFkTonTai(t)== false){
            return null;
        }

        // thực thể này đã tồn tại thì return null;
        // nếu thực thể yếu đã tồn tại thì return null
        if(this.findById(t.getUserId())!= null){
            return null;
        }

        return this.nvRepo.create(t);
    }

    @Override
    public NhanVien update(Long tKey, NhanVien t) {
        
        // dù chỉ 1 FK không tồn tại thì return null
        if(this.checkFkTonTai(t)== false){
            return null;
        }
        // thực thể này không tồn tại thì return null
        if(this.checkPkTonTai(tKey)==false){
            return null;
        }

        return this.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {

        // thực thể không tồn tại thì return false;
        if(this.checkPkTonTai(tKey)==false){
            return false;
        }

        return this.nvRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(NhanVien t) {
        if(this.userService.checkKeyTonTai(t.getUserId())==false ){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        NhanVien t = this.findById(tKey);

        if(t==null){
            return false;
        }
        
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        NhanVien t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }
    
    
}
