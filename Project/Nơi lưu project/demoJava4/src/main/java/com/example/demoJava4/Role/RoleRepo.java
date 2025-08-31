package com.example.demoJava4.Role;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;

@Repository
public class RoleRepo 
    implements RepoInterface<Role, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RoleRowMapper roleRowMapper= new RoleRowMapper();

    @Override
    public Role findById(Long tKey) {
        String sql = "SELECT * FROM Role WHERE id=?";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };

        return this.jdbcTemplate.query(psCreator, this.roleRowMapper).stream().findFirst().orElse(null);
    }


    @Override
    public List<Role> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM Role "
            + " WHERE 1=1 "
            + " ORDER BY id DESC "
            + " OFFSET ? ROW "
            + " FETCH NEXT ? ROW ONLY ";


        PreparedStatementCreator psCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ( (sizePage-1)*sttPage ) );
            ps.setInt(2, sizePage);

            return ps;
        };

        return jdbcTemplate.query(psCreator, this.roleRowMapper);
    }

    @Override
    public Role create(Role t) {

        t.setId(null);

        String sql = " INSERT INTO Role (name, mota) VALUES (?, ?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // điền tham số
            ps.setString(1, t.getName());
            ps.setString(2, t.getMota());

            return ps;
        };

        jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);

    }


    @Override
    public Role update(Long tKey, Role t) {
        t.setId(tKey);

        String sql = " UPDATE Role SET name = ?, mota = ? WHERE id = ? ";


        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getName());
            ps.setString(2, t.getMota());
            ps.setLong(3, t.getId());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(tKey);
    }


    @Override
    public Boolean delete(Long tKey) {
        String sql = "DELETE FROM Role WHERE id = ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };

        jdbcTemplate.update(psCreator);
        
        return true;
    }

    // 🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩🟩 // 

    public Role findByName(String name){
        String sql= "SELECT * FROM Role WHERE name= ? ";

        PreparedStatementCreator psCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);

            return ps;
        };

        return this.jdbcTemplate.query(psCreator, this.roleRowMapper).stream().findFirst().orElse(null);

    }
}

/*
SELECT 
    DISTINCT 
    * 
    FROM Role 
    WHERE 1=1 
    ORDER BY id DESC 
    OFFSET ? ROW  
    FETCH NEXT ? ROW ONLY 
*/

/*
UPDATE Role 
    SET 
        name = ?, 
        mota = ? 
    WHERE id = ? 
*/