package com.example.demoJava6.User;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String sodienthoai;
    private Boolean enabled;

    public User() {
    }
    
    public User(Long id, String username, String password, String email, String sodienthoai, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.enabled = enabled;
    }

    
}
