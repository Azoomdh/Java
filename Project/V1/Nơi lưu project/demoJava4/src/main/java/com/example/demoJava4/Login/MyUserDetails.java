package com.example.demoJava4.Login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demoJava4.Role.Role;
import com.example.demoJava4.Role.RoleService;
import com.example.demoJava4.RolesOfUser.RolesOfUser;
import com.example.demoJava4.RolesOfUser.RolesOfUserService;
import com.example.demoJava4.User.User;

public class MyUserDetails 
    implements UserDetails
{
    private User user;

    RolesOfUserService rouService;

    RoleService roleService;

    public MyUserDetails(User user) {
        this.user = user;
    }
    

    public MyUserDetails(User user, RolesOfUserService rouService, RoleService roleService) {
        this.user = user;
        this.rouService = rouService;
        this.roleService = roleService;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RolesOfUser> listRou1 = this.rouService.findByIdUser(this.user.getId()); 
        
        List<SimpleGrantedAuthority> dsAuthorities = new ArrayList<>();

        for(RolesOfUser rou1 : listRou1){
            Role role1 = this.roleService.findById(rou1.getRouKey().getRoleid());
            String nameOfRole1 = role1.getName();

            SimpleGrantedAuthority sgAuth1 = new SimpleGrantedAuthority(nameOfRole1);

            dsAuthorities.add(sgAuth1);
        }

        return dsAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }

    
}
