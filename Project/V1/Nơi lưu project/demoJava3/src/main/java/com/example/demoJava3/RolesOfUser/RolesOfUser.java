package com.example.demoJava3.RolesOfUser;

import com.example.demoJava3.Role.Role;
import com.example.demoJava3.User.Users;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class RolesOfUser {
    
    @EmbeddedId
    private RolesOfUserKey rouKey = new RolesOfUserKey();

    @ManyToOne
    @MapsId("role_IdEmbeded")
    @JoinColumn(name = "ma_role")
    private Role role;

    @ManyToOne
    @MapsId("user_IdEmbeded")
    @JoinColumn(name = "ma_user")
    private Users user;

    public RolesOfUser() {
    }

    public RolesOfUser(RolesOfUserKey rouKey, Role role, Users user) {
        this.rouKey = rouKey;
        this.role = role;
        this.user = user;
    }

}
