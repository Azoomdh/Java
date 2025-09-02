package com.example.demoJava4.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class UserRowMapper 
    implements RowMapper<User>
{

    @Override
    @Nullable
    public User mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long id             = ketQuaTraVe.getLong   ("id");
        String username     = ketQuaTraVe.getString ("username");
        String password     = ketQuaTraVe.getString ("password");
        String email        = ketQuaTraVe.getString ("email");
        String sodienthoai  = ketQuaTraVe.getString ("sodienthoai");
        Boolean enabled     = ketQuaTraVe.getBoolean("enabled");

        User user1 = new User(id, username, password, email, sodienthoai, enabled);
        
        return user1;
    }

}
