package com.example.demoJava3.RolesOfUser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RolesOfUserService {

    @Autowired
    private RolesOfUserRepo rouRepo;

    public RolesOfUser getById(RolesOfUserKey rouId){
        Optional<RolesOfUser> optRou1 = this.rouRepo.findById(rouId);

        if(optRou1.isPresent()== false){
            return null;
        }
        else {
            return optRou1.get();
        }
    }

    public Page<RolesOfUser> getList(Integer sttPage, Integer sizePage){
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return this.rouRepo.findAll(pageable1);
    }

    // public RolesOfUser update(RolesOfUserKey rouId, RolesOfUser rou2){
    // }

    public RolesOfUser create(RolesOfUser rou2){
        rou2 = this.rouRepo.save(rou2);
        return rou2;
    }

    public Boolean delete(RolesOfUserKey rouKey){
        Boolean isSuccess= null;

        RolesOfUser rou1 = this.getById(rouKey);

        if(rou1==null){
            isSuccess = false;
            return isSuccess;
        }
        else {
            this.rouRepo.delete(rou1);
            isSuccess = true;
            return isSuccess;
        }
    }
}
