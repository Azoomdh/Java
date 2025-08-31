package com.example.demoJava4.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // 🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩🟩 // 

    public Role findByName(String name){
        return this.roleRepo.findByName(name);
    }

    
}
