package com.example.demoJava4.RolesOfUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class RolesOfUserService 
    implements ServiceInterface<RolesOfUser, RolesOfUserKey>
{

    @Autowired
    RolesOfUserRepo rouRepo;

    @Override
    public RolesOfUser findById(RolesOfUserKey tKey) {
        return this.rouRepo.findById(tKey);
    }

    @Override
    public List<RolesOfUser> getList(Integer sttPage, Integer sizePage) {
        return this.rouRepo.getList(sttPage, sizePage);
    }

    @Override
    public RolesOfUser create(RolesOfUser t) {
        // PK là FK nên không được set PK thành null

        RolesOfUser rou1 = this.findById(t.getRouKey());

        if(rou1!= null){
            return null;
        }

        return this.rouRepo.create(t);
    }

    @Override
    public RolesOfUser update(RolesOfUserKey tKey, RolesOfUser t) {
        
        RolesOfUser rou1 = this.findById(tKey);

        if(rou1==null){
            return null;
        }
        return this.update(tKey, t);
    }

    @Override
    public Boolean delete(RolesOfUserKey tKey) {
        return this.rouRepo.delete(tKey);
    }
    
    //🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩//

    public List<RolesOfUser> findByIdUser(Long idUser){
        return this.rouRepo.findByIdUser(idUser);
    }
}
