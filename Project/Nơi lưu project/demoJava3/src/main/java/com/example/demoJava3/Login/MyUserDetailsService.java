package com.example.demoJava3.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demoJava3.User.Users;
import com.example.demoJava3.User.UsersRepo;

public class MyUserDetailsService 
    implements UserDetailsService
{
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user1 = this.usersRepo.findByUsername(username).get(0);
        
        if(user1 == null){
            throw new UsernameNotFoundException("không tìm được user");
        }

        return new MyUserDetails(user1);
    }
    
}
