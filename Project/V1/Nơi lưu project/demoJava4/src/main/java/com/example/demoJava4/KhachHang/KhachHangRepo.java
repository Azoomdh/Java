package com.example.demoJava4.KhachHang;

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
public class KhachHangRepo 
    implements RepoInterface<KhachHang, Long>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private KhachHangRowMapper khRowMapper = new KhachHangRowMapper();

    @Override
    public KhachHang findById(Long tKey) {
        String sql =  "SELECT * FROM KhachHang WHERE Userid= ? ";

        PreparedStatementCreator psc = con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.khRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<KhachHang> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM KhachHang "
            + " WHERE 1=1 "
            + " ORDER BY Userid DESC "
            + " OFFSET ? ROW "
            + " FETCH NEXT ? ROW ONLY ";

        PreparedStatementCreator psc = con-> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ( (sizePage-1)*sttPage) );
            ps.setInt(2, sizePage);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.khRowMapper);
    }

    @Override
    public KhachHang create(KhachHang t) {
        // PK của KhachHang là FK nên không được set null PK

        String sql =
            "INSERT INTO KhachHang "
            + " (Userid) "
            + " VALUES (?) ";

        // PK của KhachHang là FK nên không cần get Key trả về

        PreparedStatementCreator psc = con-> {
            PreparedStatement ps = con.prepareStatement(sql);

            // điền tham số vào dấu ?
            ps.setLong(1, t.getUserId());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(t.getUserId());
    }

    @Override
    public KhachHang update(Long tKey, KhachHang t) {
        t.setUserId(tKey);

        String sql =
            " UPDATE KhachHang "
            + " SET "
                + " "
            + " WHERE "
                + " Userid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, t.getUserId());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(t.getUserId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql =
            " DELETE FROM KhachHang " 
            + " WHERE Userid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);

            return ps;
        };

        jdbcTemplate.update(psc);

        return true;

    }



}
