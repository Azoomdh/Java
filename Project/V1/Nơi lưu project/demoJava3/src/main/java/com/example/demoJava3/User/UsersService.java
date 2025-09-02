package com.example.demoJava3.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepo userRepo;

    public Users getById(Long id){
        Optional<Users> optUser1= this.userRepo.findById(id);

        if(optUser1.isPresent()==false){
            return null;
        }
        else {
            return optUser1.get();
        }
    }

    public Page<Users> getList(Integer sttPage, Integer sizePage){
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return this.userRepo.findAll(pageable1);
    }

    public Users update(Long id, Users user2){
        Users user1 = this.getById(id);

        if(user1 == null){
            return null;
        }
        else {
            user1.updateNotId(user2);
            user1 = this.userRepo.save(user1);
            return user1;
        }
    }

    public Users create(Users user2){
        user2.setMaUser(null);
        user2= this.userRepo.save(user2);
        return user2;
    }

    public Boolean delete(Long id){
        Boolean isSuccess= null;

        Users user1 = this.getById(id);

        if(user1 == null){
            isSuccess= false;
            return isSuccess;
        }
        else {
            this.userRepo.delete(user1);
            isSuccess= true;
            return isSuccess;
        }
    }
}
