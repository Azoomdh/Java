package com.example.demoJava4.RolesOfUser;

import lombok.Data;

@Data
public class RolesOfUserKey {
    private Long userId;
    private Long roleId;
    
    public RolesOfUserKey(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    
}
