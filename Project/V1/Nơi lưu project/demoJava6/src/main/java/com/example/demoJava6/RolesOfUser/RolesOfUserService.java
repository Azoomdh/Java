package com.example.demoJava6.RolesOfUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class RolesOfUserService 
    implements ServiceInterface<RolesOfUser, RolesOfUserId>
{

    @Autowired
    private RolesOfUserRepo rolesOfUserRepo;

    @Override
    public RolesOfUser findById(RolesOfUserId id) {
        return this.rolesOfUserRepo.findById(id);
    }

    @Override
    public List<RolesOfUser> getList(Integer sttPage, Integer sizePage) {
        return this.rolesOfUserRepo.getList(sttPage, sizePage);
    }

    @Override
    public RolesOfUser create(RolesOfUser t) {
        return this.rolesOfUserRepo.create(t);
    }
    
    @Override
    public RolesOfUser update(RolesOfUserId id, RolesOfUser t) {
        t.setId(id);
        return this.rolesOfUserRepo.update(id, t);
    }

    @Override
    public Boolean delete(RolesOfUserId id) {
        return this.rolesOfUserRepo.delete(id);
    }

    public List<RolesOfUser> findByUserid(Long userId){
        return this.rolesOfUserRepo.findByUserid(userId);
    }
}
