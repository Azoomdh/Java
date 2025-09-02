package com.example.demoJava3.User;

import java.util.Set;

import com.example.demoJava3.RolesOfUser.RolesOfUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long maUser;

    @Column(unique = true)
    private String username;

    private String password;
    private String ten;
    private String email;
    private String sodienthoai;
    private Boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<RolesOfUser> rolesOfUser;

    public void updateNotId(Users user2){
        this.password       = user2.getPassword()       ;
        this.ten            = user2.getTen()            ;
        this.email          = user2.getEmail()          ;
        this.sodienthoai    = user2.getSodienthoai()    ;
        this.enabled        = user2.getEnabled()        ;
    }
}
