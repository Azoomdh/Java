package com.example.demoJava2.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private Boolean enabled;

    public void updateNotId(User user2){
        this.username   = user2.getUsername();
        this.password   = user2.getPassword();
        this.role       = user2.getRole();
        this.enabled    = user2.getEnabled();
    }

    public User() {
    }

    public User(String username, String password, String role, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public User(Long id, String username, String password, String role, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    
}
