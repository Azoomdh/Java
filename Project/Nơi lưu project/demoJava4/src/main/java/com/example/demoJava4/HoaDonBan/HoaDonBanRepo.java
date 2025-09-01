package com.example.demoJava4.HoaDonBan;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;

@Repository
public class HoaDonBanRepo 
    implements RepoInterface<HoaDonBan, Long>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private HoaDonBanRowMapper hoaDonBanRowMapper = new HoaDonBanRowMapper();

    @Override
    public HoaDonBan findById(Long tKey) {
        String sql = "SELECT * FROM HoaDonBan WHERE id=? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.hoaDonBanRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<HoaDonBan> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM HoaDonBan "
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

        return jdbcTemplate.query(psCreator, this.hoaDonBanRowMapper);
    }

    @Override
    public HoaDonBan create(HoaDonBan t) {
        t.setId(null);

        String sql = 
            " INSERT INTO HoaDonBan "
                + " (thoigian, sotien, lathanhtoantienmat, MotLuotBanid) " 
                + " (?, ?, ?, ?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setLong(2, t.getSotien());
            ps.setBoolean(3, t.getLathanhtoantienmat());
            ps.setLong(4, t.getMotLuotBanid());

            return ps;
        };

        this.jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);
    }

    @Override
    public HoaDonBan update(Long tKey, HoaDonBan t) {
        t.setId(tKey);

        String sql = 
            " UPDATE HoaDonBan "
                + " SET "
                    + " thoigian = ?, "
                    + " sotien = ?, "
                    + " lathanhtoantienmat = ?, "
                    + " MotLuotBanid = ? "
                + " WHERE "
                    + " id = ? ";
        
        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setLong(2, t.getSotien());
            ps.setBoolean(3, t.getLathanhtoantienmat());
            ps.setLong(4, t.getMotLuotBanid());
            ps.setLong(5, t.getId());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = " DELETE FROM HoaDonBan WHERE id = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;
    }

}
