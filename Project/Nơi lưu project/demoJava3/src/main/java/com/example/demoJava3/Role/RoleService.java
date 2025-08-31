package com.example.demoJava3.Role;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role getByName(String name){
        return this.roleRepo.findByName("CLIENT").get(0);
    }

    public Role getById(Long id){
        Optional<Role> optRole1= this.roleRepo.findById(id);

        if(optRole1.isPresent()== false){
            return null;
        }
        else {
            return optRole1.get();
        }
    }

    public Page<Role> getList(Integer sttPage, Integer sizePage){
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return this.roleRepo.findAll(pageable1);
    }

    public Role update(Long id, Role role2){
        Role role1 = this.getById(id);

        if(role1 == null){
            return null;
        }
        else {
            role1.updateNotId(role2);
            role1= this.roleRepo.save(role1);
            return role1;
        }
    }

    public Role create(Role role2){
        role2.setMaRole(null);
        role2 = this.roleRepo.save(role2);
        return role2;
    }

    public Boolean delete(Long id){
        Boolean isSuccess = null;

        Role role1 = this.getById(id);

        if(role1==null){
            isSuccess = false;
            return isSuccess;
        }
        else {
            this.roleRepo.delete(role1);
            isSuccess = true;
            return isSuccess;
        }
    }
}
