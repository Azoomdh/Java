package com.example.demoJava4.MotLuotNhap;

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
public class MotLuotNhapRepo 
    implements RepoInterface<MotLuotNhap, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MotLuotNhapRowMapper motLuotNhapRowMapper = new MotLuotNhapRowMapper();

    @Override
    public MotLuotNhap findById(Long tKey) {
        String sql = "SELECT * FROM MotLuotNhap WHERE id=? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.motLuotNhapRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<MotLuotNhap> getList(Integer sttPage, Integer sizePage) {

        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM MotLuotNhap "
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

        return jdbcTemplate.query(psCreator, this.motLuotNhapRowMapper);

    }

    @Override
    public MotLuotNhap create(MotLuotNhap t) {
        t.setId(null);

        String sql = 
            " INSERT INTO MotLuotNhap "
                + " (thoigian, dathanhtoan, CuaHangid, NhaCungCapid, NhanVienUserid) "   
                + " (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = con->{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getCuaHangid());
            ps.setLong(4, t.getNhaCungCapid());
            ps.setLong(5, t.getNhanVienUserid());

            return ps;
        };

        this.jdbcTemplate.update(psc, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return this.findById(id);
    }


    @Override
    public MotLuotNhap update(Long tKey, MotLuotNhap t) {
        String sql= 
            "UPDATE MotLuotNhap "
                + " SET " 
                    + "  thoigian = ?, " 
                    + "  dathanhtoan = ?, "  
                    + "  CuaHangid = ?, " 
                    + "  NhaCungCapid = ?, " 
                    + "  NhanVienUserid = ? " 
                + "WHERE " 
                    + "  id = ?" ;

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getCuaHangid());
            ps.setLong(4, t.getNhaCungCapid());
            ps.setLong(5, t.getNhanVienUserid());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = " DELETE FROM MotLuotNhap WHERE id = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey);

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;

    }

}
