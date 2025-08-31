package com.example.demoJava4.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class RoleRowMapper 
    implements RowMapper<Role>
{

    @Override
    @Nullable
    public Role mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long id         = ketQuaTraVe.getLong   ("id")      ;
        String name     = ketQuaTraVe.getString ("name")    ;
        String mota     = ketQuaTraVe.getString ("mota")    ;

        Role role1 = new Role(id, name, mota);
        
        return role1;
    }
    
}
