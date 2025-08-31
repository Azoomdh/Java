package com.example.demoJava4.RolesOfUser;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class RolesOfUserRowMapper 
    implements RowMapper<RolesOfUser>
{

    @Override
    @Nullable
    public RolesOfUser mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long Userid = ketQuaTraVe.getLong("Userid");
        Long Roleid = ketQuaTraVe.getLong("Roleid");

        RolesOfUserKey rouKey1 = new RolesOfUserKey(Userid, Roleid);

        RolesOfUser rou1 = new RolesOfUser(rouKey1);

        return rou1;
    }
    
}
