package com.example.demoJava4.NhaCungCap;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;
import com.example.demoJava4.MotLuotBan.MotLuotBan;

@Repository
public class NhaCungCapRepo 
    implements RepoInterface<NhaCungCap, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private NhaCungCapRowMapper nhaCungCapRowMapper = new NhaCungCapRowMapper();

    @Override
    public NhaCungCap findById(Long tKey) {
        String sql = "SELECT * FROM NhaCungCap WHERE id=? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.nhaCungCapRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<NhaCungCap> getList(Integer sttPage, Integer sizePage) {

        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM NhaCungCap "
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

        return jdbcTemplate.query(psCreator, this.nhaCungCapRowMapper);

    }

    @Override
    public NhaCungCap create(NhaCungCap t) {
        t.setId(null);

        String sql = 
            " INSERT INTO NhaCungCap "
                + " ( name, address, sodienthoai, email, mota) "
                + " (?, ?, ?, ?, ?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getName());
            ps.setString(2, t.getAddress());
            ps.setString(3, t.getSodienthoai());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getMota());

            return ps;
        };

        this.jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);
    }

        @Override
    public NhaCungCap update(Long tKey, NhaCungCap t) {
        t.setId(tKey);

        String sql= 
            "UPDATE MotLuotBan "
                + " SET " 
                    + " name = ?, "
                    + " address = ?, "
                    + " sodienthoai = ?, " 
                    + " email = ?, " 
                    + " mota = ? " 
                + "WHERE " 
                    + "  id = ?" ;

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getName());
            ps.setString(2, t.getAddress());
            ps.setString(3, t.getSodienthoai());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getMota());
            ps.setLong(6, t.getId());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = " DELETE FROM NhaCungCap WHERE id = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;

    }
}
