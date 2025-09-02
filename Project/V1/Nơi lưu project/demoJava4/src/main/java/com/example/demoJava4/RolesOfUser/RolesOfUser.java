package com.example.demoJava4.RolesOfUser;

import com.example.demoJava4.Interface.EntityInterface;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class RolesOfUser 
    implements EntityInterface<RolesOfUser, RolesOfUserKey>
{
    private RolesOfUserKey rouKey;

    // @Override
    // public void updateNotId(RolesOfUser o2) {
    //     // ko lam gi ca
    //     return;
    // }

    public RolesOfUser(RolesOfUserKey rouKey) {
        this.rouKey = rouKey;
    }
    
}
