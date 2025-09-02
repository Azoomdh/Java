package com.example.demoJava4.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.CuaHang.CuaHang;
import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class RoleService 
    implements ServiceInterface<Role, Long>
{
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findById(Long tKey) {
        return this.roleRepo.findById(tKey);
    }

    @Override
    public List<Role> getList(Integer sttPage, Integer sizePage) {
        return this.roleRepo.getList(sttPage, sizePage);
    }

    @Override
    public Role create(Role t) {
        t.setId(null);

        Role role1 = this.findByName(t.getName());

        if(role1 != null){
            return null;
        }

        return this.roleRepo.create(t);
    }

    @Override
    public Role update(Long tKey, Role t) {
        Role role1 = this.findById(tKey);

        if(role1==null) {
            return null;
        }

        return this.roleRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.roleRepo.delete(tKey);
    }

    @Override
    public Boolean checkFkTonTai(Role t) {
        // role không có fk
        return true;
    }

    @Override
    public Boolean checkPkTonTai(Long tKey) {
        Role t = this.findById(tKey);
        if(t==null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkKeyTonTai(Long tKey) {
        Role t = this.findById(tKey);
        
        if(t== null){
            return false;
        }

        if(checkFkTonTai(t)==false){
            return false;
        }
        return true;
    }

    // 🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩🟩 // 

    public Role findByName(String name){
        return this.roleRepo.findByName(name);
    }

    
}
