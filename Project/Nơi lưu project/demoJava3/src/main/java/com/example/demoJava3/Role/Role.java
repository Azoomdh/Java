package com.example.demoJava3.Role;

import java.util.Set;

import com.example.demoJava3.RolesOfUser.RolesOfUser;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maRole;
    
    private String name;
    private String moTa;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<RolesOfUser> rolesOfUser;

    public void updateNotId(Role role2){
        this.name = role2.getName();
        this.moTa = role2.getMoTa();
    }
}
