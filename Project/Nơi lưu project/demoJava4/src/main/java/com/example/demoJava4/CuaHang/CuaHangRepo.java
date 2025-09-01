package com.example.demoJava4.CuaHang;

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
public class CuaHangRepo 
    implements RepoInterface<CuaHang, Long>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CuaHangRowMapper cuahangRowMapper = new CuaHangRowMapper();

    @Override
    public CuaHang findById(Long tKey) {
        String sql= " SELECT * FROM CuaHang WHERE id = ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };
        return jdbcTemplate.query(psCreator, this.cuahangRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<CuaHang> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM CuaHang "
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

        return jdbcTemplate.query(psCreator, this.cuahangRowMapper);
    }

    @Override
    public CuaHang create(CuaHang t) {
        t.setId(null);

        String sql=
            " INSERT INTO CuaHang "
            + " (name, diachi, sodienthoai, mota) " 
            + " VALUES (?, ?, ?, ?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psCreator = con -> {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // điền tham số
            ps.setString(1, t.getName());
            ps.setString(2, t.getDiachi());
            ps.setString(3, t.getSodienthoai());
            ps.setString(4, t.getMota());

            return ps;
        };

        jdbcTemplate.update(psCreator, keyHolder);

        Long id = keyHolder.getKey().longValue();
        
        return this.findById(id);
    }

    @Override
    public CuaHang update(Long tKey, CuaHang t) {
        t.setId(tKey);

        String sql=
            "UPDATE CuaHang" 
                + "SET" 
                    + "name = ?, "
                    + "diachi = ?," 
                    + "sodienthoai = ?," 
                    + "mota = ? "
                + "WHERE"
                    + "id = ?";
        
        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getName());
            ps.setString(2, t.getDiachi());
            ps.setString(3, t.getSodienthoai());
            ps.setString(4, t.getMota());
            ps.setLong(5, t.getId());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

     @Override
    public Boolean delete(Long tKey) {
        String sql = "DELETE FROM CuaHang WHERE id = ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };

        jdbcTemplate.update(psCreator);
        
        return true;
    }

}
