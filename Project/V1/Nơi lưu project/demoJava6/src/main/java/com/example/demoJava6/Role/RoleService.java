package com.example.demoJava6.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class RoleService 
    implements ServiceInterface<Role, Long>
{

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findById(Long id) {
        return this.roleRepo.findById(id);
    }

    @Override
    public List<Role> getList(Integer sttPage, Integer sizePage) {
        return this.roleRepo.getList(sttPage, sizePage);
    }
    @Override

    public Role create(Role t) {
        return this.roleRepo.create(t);
    }

    @Override
    public Role update(Long id, Role t) {
        return this.roleRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.roleRepo.delete(id);
    }

    public Role findByName(String name){
        return this.roleRepo.findByName(name);
    }
}
