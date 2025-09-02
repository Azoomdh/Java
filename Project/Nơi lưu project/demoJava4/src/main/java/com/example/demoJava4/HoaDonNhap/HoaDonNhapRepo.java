package com.example.demoJava4.HoaDonNhap;

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
public class HoaDonNhapRepo
    implements RepoInterface<HoaDonNhap, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private HoaDonNhapRowMapper hoaDonNhapRowMapper = new HoaDonNhapRowMapper();

    @Override
    public HoaDonNhap findById(Long tKey) {
       String sql = "SELECT * FROM HoaDonNhap WHERE id=? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.hoaDonNhapRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<HoaDonNhap> getList(Integer sttPage, Integer sizePage) {

        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM HoaDonNhap "
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
        return jdbcTemplate.query(psCreator, this.hoaDonNhapRowMapper);
    }

    @Override
    public HoaDonNhap create(HoaDonNhap t) {
        t.setId(null);

        String sql = 
            " INSERT INTO HoaDonNhap "
                + " (thoigian, sotien, lathanhtoantienmat, MotLuotNhapid) " 
                + " (?, ?, ?, ?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setLong(2, t.getSotien());
            ps.setBoolean(3, t.getLathanhtoantienmat());
            ps.setLong(4, t.getMotLuotNhapid());

            return ps;
        };

        this.jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);
    }

    @Override
    public HoaDonNhap update(Long tKey, HoaDonNhap t) {
        t.setId(tKey);

        String sql = 
            " UPDATE HoaDonNhap "
                + " SET "
                    + " thoigian = ?, "
                    + " sotien = ?, "
                    + " lathanhtoantienmat = ?, "
                    + " MotLuotNhapid = ? "
                + " WHERE "
                    + " id = ? ";
        
        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setLong(2, t.getSotien());
            ps.setBoolean(3, t.getLathanhtoantienmat());
            ps.setLong(4, t.getMotLuotNhapid());
            ps.setLong(5, t.getId());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = " DELETE FROM HoaDonNhap WHERE id = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;
    }



}
