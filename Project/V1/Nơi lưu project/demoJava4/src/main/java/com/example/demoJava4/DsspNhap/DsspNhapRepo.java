package com.example.demoJava4.DsspNhap;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;

@Repository
public class DsspNhapRepo 
    implements RepoInterface<DsspNhap, DsspNhapKey>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private DsspNhapRowMapper dsspNhapRowMapper = new DsspNhapRowMapper();

    @Override
    public DsspNhap findById(DsspNhapKey tKey) {
        String sql =
            " SELECT "
                + " * "
                + " FROM DsspNhap "
                + " WHERE "
                    + " VatPhamid = ? "
                    + " MotLuotNhapid = ? ";
        
        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey.getVatPhamid());
            ps.setLong(2, tKey.getMotLuotNhapid());

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.dsspNhapRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<DsspNhap> getList(Integer sttPage, Integer sizePage) {
        String sql = 
        "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM DsspNhap "
            + " WHERE 1=1 "
            + " ORDER BY MotLuotNhapid DESC, VatPhamid DESC "
            + " OFFSET ? ROW "
            + " FETCH NEXT ? ROW ONLY ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ( (sizePage-1)*sttPage ) );
            ps.setInt(2, sizePage);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.dsspNhapRowMapper);
    }

    @Override
    public DsspNhap create(DsspNhap t) {
        String sql =
            " INSERT INTO DsspNhap "
                + " (MotLuotNhapid, VatPhamid, soluong, gia) " 
                + " VALUES (?, ?, ?, ?) ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, t.getDsspNhapKey().getMotLuotNhapid());
            ps.setLong(2, t.getDsspNhapKey().getVatPhamid());
            ps.setInt(3, t.getSoluong());
            ps.setLong(4, t.getGia());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getDsspNhapKey());
    }


    @Override
    public DsspNhap update(DsspNhapKey tKey, DsspNhap t) {
        t.setDsspNhapKey(tKey);

        String sql =
            "UPDATE DsspNhap "
                + " SET "
                    + " soluong = ?, "
                    + " gia = ? "
                + " WHERE "
                    + " MotLuotNhapid = ? "
                    + " AND VatPhamid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, t.getSoluong());
            ps.setLong(2, t.getGia());
            ps.setLong(3, t.getDsspNhapKey().getMotLuotNhapid());
            ps.setLong(4, t.getDsspNhapKey().getVatPhamid());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getDsspNhapKey());
    }

    @Override
    public Boolean delete(DsspNhapKey tKey) {
        String sql =
            " DELETE FROM DsspNhap "
                + " WHERE " 
                    + " MotLuotNhapid = ? " 
                    + " AND VatPhamid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey.getMotLuotNhapid());
            ps.setLong(2, tKey.getVatPhamid());

            return ps;
        };
        this.jdbcTemplate.update(psc);

        return true;
    }



}
