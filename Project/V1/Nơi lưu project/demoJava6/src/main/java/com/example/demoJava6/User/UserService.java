package com.example.demoJava6.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava6.Interface.ServiceInterface;

@Service
public class UserService 
    implements ServiceInterface<User, Long>
{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(Long id) {
        return this.userRepo.findById(id);
    }

    @Override
    public List<User> getList(Integer sttPage, Integer sizePage) {
        return this.userRepo.getList(sttPage, sizePage);
    }
    @Override

    public User create(User t) {
        return this.userRepo.create(t);
    }

    @Override
    public User update(Long id, User t) {
        return this.userRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.userRepo.delete(id);
    }

    public User findByUsername(String username){
        return this.userRepo.findByUsername(username);
    }

}
