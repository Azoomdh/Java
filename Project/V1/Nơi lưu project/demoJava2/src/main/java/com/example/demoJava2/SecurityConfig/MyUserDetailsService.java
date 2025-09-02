package com.example.demoJava2.SecurityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demoJava2.User.User;
import com.example.demoJava2.User.UserReposistory;
import com.example.demoJava2.User.UserReposistoryCustom;

@Service
public class MyUserDetailsService 
    implements UserDetailsService
{
    @Autowired
    private UserReposistory userRepo;

    @Autowired
    private UserReposistoryCustom userRepoCustom;

    @Override
    public UserDetails loadUserByUsername(String username) 
        throws UsernameNotFoundException 
    {
        Optional<User> optUser1 = this.userRepo.findByUsername(username);
        
        if(optUser1.isPresent()== false){
            throw new UsernameNotFoundException("khong tim duoc user");
        }
        User user1 = optUser1.get();
        return new MyUserDetails(user1);
    }

    
}
 