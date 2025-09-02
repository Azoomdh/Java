package com.example.demoJava4.RolesOfUser;

import lombok.Data;

@Data
public class RolesOfUserKey {
    private Long Userid;
    private Long Roleid;
    
    public RolesOfUserKey(Long userId, Long roleId) {
        this.Userid = userId;
        this.Roleid = roleId;
    }

    
}
