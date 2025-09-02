package com.example.demoJava2.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class UserRowMapper 
    implements RowMapper<User>
{

    @Override
    @Nullable
    public User mapRow(ResultSet hangTraVe, int stthang) {

        try {
            Long    id          = null;
            String  username    = null;
            String  password    = null;
            String  role        = null;
            Boolean enabled     = null;

            id          = hangTraVe.getLong     ("id"       );
            username    = hangTraVe.getString   ("username" );
            password    = hangTraVe.getString   ("password" );
            role        = hangTraVe.getString   ("role"     );
            enabled     = hangTraVe.getBoolean  ("enabled"  );

            User user1 = new User(id, username, password, role, enabled);

            return user1;
        }

        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
