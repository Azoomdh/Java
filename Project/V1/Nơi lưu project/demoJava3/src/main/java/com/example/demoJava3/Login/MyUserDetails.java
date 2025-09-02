package com.example.demoJava3.Login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demoJava3.RolesOfUser.RolesOfUser;
import com.example.demoJava3.User.Users;

public class MyUserDetails 
    implements UserDetails
{
    private Users user;

    public MyUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Set<RolesOfUser> listRou1 = this.user.getRolesOfUser();

        List<SimpleGrantedAuthority> dsAuthorities = new ArrayList<>();

        for(RolesOfUser rou1 : listRou1){
            String nameRole1 = rou1.getRole().getName();
            SimpleGrantedAuthority sgAuthority1 = new SimpleGrantedAuthority(nameRole1);
            
            dsAuthorities.add(sgAuthority1);
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
        return this.user.getEnabled();
    }

    
}
