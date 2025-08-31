package com.example.demoJava4.User;

import com.example.demoJava4.Interface.EntityInterface;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class User 
    implements EntityInterface<User, Long> 
{
    private Long id;

    private String username;
    private String password;
    private String email;
    private String sodienthoai;
    private Boolean enabled;
    
    @Override
    public void updateNotId(User o2) {
        this.id = o2.getId();
        this.username = o2.getUsername();
        this.password = o2.getPassword();
        this.email = o2.getEmail();
        this.sodienthoai = o2.getSodienthoai();
        this.enabled = o2.getEnabled();
    }

    public User(String username, String password, String email, String sodienthoai, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.enabled = enabled;
    }

    public User(Long id, String username, String password, String email, String sodienthoai, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.enabled = enabled;
    }

    public User() {
    }

    
}
