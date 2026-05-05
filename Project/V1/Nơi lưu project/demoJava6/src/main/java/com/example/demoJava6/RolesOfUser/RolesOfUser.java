package com.example.demoJava6.RolesOfUser;

import lombok.Data;

@Data
public class RolesOfUser {

    private RolesOfUserId id;

    public RolesOfUser() {
    }

    public RolesOfUser(RolesOfUserId id) {
        this.id = id;
    }

    
}
