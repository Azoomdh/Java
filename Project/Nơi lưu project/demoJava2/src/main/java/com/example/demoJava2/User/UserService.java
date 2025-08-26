package com.example.demoJava2.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserReposistory userRepo;

    public User getUsersById(Long id){
        Optional<User> optUser1 = this.userRepo.findById(id);

        if(optUser1.isPresent()==true){
            return optUser1.get();
        }
        else{
            return null;
        }
    }

    public Page<User> getListUser(Integer sttPage, Integer sizePage){
        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return this.userRepo.findAll(pageable1);
    }

    public User createUser(User user1){
        user1.setId(null);

        user1 = this.userRepo.save(user1);

        return user1;
    }

    // public List<User> createUser(List<User> listUser1){
    //     for(User user1 : listUser1){
    //         user1.setId(null);
    //     }

    //     listUser1 = this.userRepo.saveAll(listUser1);

    //     return listUser1;
    // }

    public User updateUser(Long idUser, User user1){
        User user2 = this.getUsersById(idUser);

        if(user2==null){
            return null;
        }
        else{
            user2.updateNotId(user1);
            user2= this.userRepo.save(user2);
            return user2;
        }
    }

    public void deleteUser(Long idUser){
        
        User user2 = this.getUsersById(idUser);

        if(user2==null){
            return;
        }
        else{
            this.userRepo.delete(user2);
            return;
        }
    }
}
