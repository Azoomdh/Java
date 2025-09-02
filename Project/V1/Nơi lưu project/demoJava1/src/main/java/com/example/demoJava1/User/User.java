package com.example.demoJava1.User;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column( name = "address", nullable = true)
    private String address;

    @Column(name = "sodienthoai", nullable = true)
    private String sodienthoai;

    @Column(name= "email", nullable= false)
    private String email;

    @Column(name= "username", nullable= false, unique = true)
    private String username;

    @Column(name= "password", nullable= false)
    private String password;

    @Column(name= "mota", nullable = true)
    private String mota;

    @Column(name = "enabled")
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User() {
    }

    public User
        (   
            String address, 
            String sodienthoai, 
            String email, 
            String username, 
            String password, 
            String mota,
            Boolean enabled
        )
        {
            this.address = address;
            this.sodienthoai = sodienthoai;
            this.email = email;
            this.username = username;
            this.password = password;
            this.mota = mota;
            this.enabled = enabled;
        }
    

    
}
