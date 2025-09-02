package com.example.demoJava4.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Role.RoleService;
import com.example.demoJava4.RolesOfUser.RolesOfUserService;
import com.example.demoJava4.User.User;
import com.example.demoJava4.User.UserService;

@Service
public class MyUserDetailsService 
    implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Autowired
    RolesOfUserService rouService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 = this.userService.findByUsername(username);
        
        if(user1==null){
            throw new UsernameNotFoundException("không tìm được user");
        }
        return new MyUserDetails(user1, rouService, roleService);
    }

}
