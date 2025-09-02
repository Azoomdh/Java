package com.example.demoJava4.DsspBan;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;

@Repository
public class DsspBanRepo 
    implements RepoInterface<DsspBan, DsspBanKey>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private DsspBanRowMapper dsspBanRowMapper = new DsspBanRowMapper();

    @Override
    public DsspBan findById(DsspBanKey tKey) {
        String sql = 
            " SELECT "
                + " * "
                + " FROM DsspBan "
                + " WHERE "
                    + " VatPhamid = ? "
                    + " MotLuotBanid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey.getVatPhamid());
            ps.setLong(2, tKey.getMotLuotBanid());

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.dsspBanRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<DsspBan> getList(Integer sttPage, Integer sizePage) {
        String sql = 
        "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM DsspBan "
            + " WHERE 1=1 "
            + " ORDER BY MotLuotBanid DESC, VatPhamid DESC "
            + " OFFSET ? ROW "
            + " FETCH NEXT ? ROW ONLY ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ( (sizePage-1)*sttPage ) );
            ps.setInt(2, sizePage);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.dsspBanRowMapper);
    }

    @Override
    public DsspBan create(DsspBan t) {
        String sql =
            " INSERT INTO DsspBan "
                + " (VatPhamid, MotLuotBanid, soluong, gia) " 
                + " VALUES (?, ?, ?, ?) ";
        
        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, t.getDsspBanKey().getVatPhamid());
            ps.setLong(2, t.getDsspBanKey().getMotLuotBanid());
            ps.setInt(3, t.getSoluong());
            ps.setLong(4, t.getGia());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getDsspBanKey());
    }

    @Override
    public DsspBan update(DsspBanKey tKey, DsspBan t) {
        t.setDsspBanKey(tKey);

        String sql=
            " UPDATE DsspBan "
                + "SET "
                    + " soluong = ?, "
                    + " gia = ? "
                + " WHERE "
                    + " VatPhamid = ? " 
                    + " AND MotLuotBanid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, t.getSoluong());
            ps.setLong(2, t.getGia());
            ps.setLong(3, t.getDsspBanKey().getVatPhamid());
            ps.setLong(4, t.getDsspBanKey().getMotLuotBanid());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return this.findById(t.getDsspBanKey());
    }

    @Override
    public Boolean delete(DsspBanKey tKey) {
        String sql = 
            " DELETE FROM DsspBan" 
                + " WHERE "
                    + " VatPhamid = ? "
                    + " AND MotLuotBanid = ? ";

        PreparedStatementCreator psc= con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey.getVatPhamid());
            ps.setLong(2, tKey.getMotLuotBanid());

            return ps;
        };

        this.jdbcTemplate.update(psc);

        return true;
    }



    
}
