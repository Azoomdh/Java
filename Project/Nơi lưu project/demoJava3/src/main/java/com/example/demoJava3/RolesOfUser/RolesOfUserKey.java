package com.example.demoJava3.RolesOfUser;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RolesOfUserKey 
    implements Serializable
{
    @Column(name = "ma_role")
    private Long role_IdEmbeded;

    @Column(name = "ma_user")
    private Long user_IdEmbeded;

    public RolesOfUserKey() {
    }

    public RolesOfUserKey(Long role_IdEmbeded, Long user_IdEmbeded) {
        this.role_IdEmbeded = role_IdEmbeded;
        this.user_IdEmbeded = user_IdEmbeded;
    }

    
}
