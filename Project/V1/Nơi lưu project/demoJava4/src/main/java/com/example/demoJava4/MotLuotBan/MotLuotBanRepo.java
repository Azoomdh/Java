package com.example.demoJava4.MotLuotBan;

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
public class MotLuotBanRepo 
    implements RepoInterface<MotLuotBan, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MotLuotBanRowMapper motLuotBanRowMapper = new MotLuotBanRowMapper();

    @Override
    public MotLuotBan findById(Long tKey) {
        String sql = "SELECT * FROM MotLuotBan WHERE id=? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.motLuotBanRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<MotLuotBan> getList(Integer sttPage, Integer sizePage) {

        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM MotLuotBan "
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

        return jdbcTemplate.query(psCreator, this.motLuotBanRowMapper);

    }

    @Override
    public MotLuotBan create(MotLuotBan t) {
        t.setId(null);

        String sql = 
            " INSERT INTO MotLuotBan "
                + " (thoigian, dathanhtoan, CuaHangid, KhachHangUserid, NhanVienUserid) "   
                + " (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhToan());
            ps.setLong(3, t.getCuaHangid());
            ps.setLong(4, t.getKhachHangUserid());
            ps.setLong(5, t.getNhanVienUserid());

            return ps;
        };

        this.jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);
    }


    @Override
    public MotLuotBan update(Long tKey, MotLuotBan t) {
        t.setId(tKey);
        
        String sql= 
            "UPDATE MotLuotBan "
                + " SET " 
                    + "  thoigian = ?, " 
                    + "  dathanhtoan = ?, "  
                    + "  CuaHangid = ?, " 
                    + "  KhachHangUserid = ?, " 
                    + "  NhanVienUserid = ? " 
                + "WHERE " 
                    + "  id = ?" ;

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhToan());
            ps.setLong(3, t.getCuaHangid());
            ps.setLong(4, t.getKhachHangUserid());
            ps.setLong(5, t.getNhanVienUserid());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = " DELETE FROM MotLuotBan WHERE id = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;

    }

}
