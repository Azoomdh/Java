package com.example.demoJava6.RolesOfUser;

import lombok.Data;

@Data
public class RolesOfUserId {

    private Long Userid;
    private Long Roleid;
    public RolesOfUserId(Long userid, Long roleid) {
        Userid = userid;
        Roleid = roleid;
    }
    public RolesOfUserId() {
    }

    
}
