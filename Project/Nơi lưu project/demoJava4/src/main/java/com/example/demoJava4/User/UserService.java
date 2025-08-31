package com.example.demoJava4.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Interface.ServiceInterface;

@Service
public class UserService 
    implements ServiceInterface<User, Long>
{
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(Long tKey) {
        return this.userRepo.findById(tKey);
    }

    @Override
    public List<User> getList(Integer sttPage, Integer sizePage) {
        return this.userRepo.getList(sttPage, sizePage);
    }

    @Override
    public User create(User t) {
        t.setId(null);
        
        User user1 = this.findByUsername(t.getUsername());

        if(user1 != null){
            return null;
        }

        return this.userRepo.create(t);
    }

    @Override
    public User update(Long tKey, User t) {
        User user1 = this.findById(tKey);

        if(user1==null){
            return null;
        }

        return this.userRepo.update(tKey, t);
    }

    @Override
    public Boolean delete(Long tKey) {
        return this.userRepo.delete(tKey);
    }

    // 🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩🟩 //

    public User findByUsername(String username){
        return this.userRepo.findByUsername(username);
    }
}
