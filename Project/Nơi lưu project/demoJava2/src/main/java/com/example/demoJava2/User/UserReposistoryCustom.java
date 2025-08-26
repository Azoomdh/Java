package com.example.demoJava2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserReposistoryCustom {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public User findByUsername(String username){
        String lenhSql1 = 
            " SELECT"
                + " *"
                + " FROM user"
                + " WHERE user.username="+ username;

        return jdbcTemplate.query(lenhSql1, new UserRowMapper()).get(0);
    }
}
