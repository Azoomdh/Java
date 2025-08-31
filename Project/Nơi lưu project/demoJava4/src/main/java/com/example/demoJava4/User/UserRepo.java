package com.example.demoJava4.User;

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
public class UserRepo 
    implements RepoInterface<User, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private UserRowMapper userRowMapper = new UserRowMapper();

    @Override
    public User findById(Long tKey) {
        String sql= "SELECT * FROM [User] WHERE id= ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };
        return jdbcTemplate.query(psCreator, this.userRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<User> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM [User] "
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

        return jdbcTemplate.query(psCreator, userRowMapper);
    }

    @Override
    public User create(User t) {

        t.setId(null);

        String sql=
            " INSERT INTO [User] "
            + " (username, password, email, sodienthoai, enabled)" 
            + " VALUES ( ?, ?, ?, ?, ? )";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psCreator = con -> {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // điền tham số vào dấu ?
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setBoolean(5, t.getEnabled());

            return ps;
        };


        jdbcTemplate.update(psCreator, keyHolder);

        Long id = keyHolder.getKey().longValue();
        
        return this.findById(id);
    }

    @Override
    public User update(Long tKey, User t) {
        t.setId(tKey);
        
        String sql = 
            " UPDATE [User] "
            + " SET " 
                + " username = ? , "
                + " password = ? , " 
                + " email = ? , "
                + " sodienthoai = ? , " 
                + " enabled = ? "
            + " WHERE id = ? ";

        PreparedStatementCreator psCreator = con -> {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setBoolean(5, t.getEnabled());
            ps.setLong(6, t.getId());

            return ps;
        };


        jdbcTemplate.update(psCreator);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = "DELETE FROM [User] WHERE id = ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };

        jdbcTemplate.update(psCreator);
        
        return true;
    }

    // 🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩🟩 // 

    public User findByUsername(String username){
        String sql= "SELECT * FROM [User] WHERE username= ? ";

        PreparedStatementCreator psCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, username);

            return ps;
        };

        return this.jdbcTemplate.query(psCreator, this.userRowMapper).stream().findFirst().orElse(null);
    }

}
