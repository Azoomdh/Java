package com.example.demoJava4.VatPham;

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
public class VatPhamRepo 
    implements RepoInterface<VatPham, Long>
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private VatPhamRowMapper vatPhamRowMapper = new VatPhamRowMapper();

    @Override
    public VatPham findById(Long tKey) {
        String sql= "SELECT * FROM VatPham WHERE id= ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };
        return jdbcTemplate.query(psCreator, this.vatPhamRowMapper).stream().findFirst().orElse(null);
    }

    @Override
    public List<VatPham> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM VatPham "
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

        return jdbcTemplate.query(psCreator, this.vatPhamRowMapper);
    }


    @Override
    public VatPham create(VatPham t) {

        t.setId(null);

        String sql=
            " INSERT INTO VatPham "
            + " ( ten, gia, donvi, mota, urlanh ) " 
            + " VALUES ( ?, ?, ?, ?, ? )";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psCreator = con -> {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // điền tham số vào dấu ?
            ps.setString(1, t.getTen());
            ps.setLong(2, t.getGia());
            ps.setString(3, t.getDonvi());
            ps.setString(4, t.getMota());
            ps.setString(5, t.getUrlanh());

            return ps;
        };


        jdbcTemplate.update(psCreator, keyHolder);

        Long id = keyHolder.getKey().longValue();
        
        return this.findById(id);
    }

    @Override
    public VatPham update(Long tKey, VatPham t) {
        t.setId(tKey);
        
        String sql = 
            " UPDATE VatPham "
                + " SET " 
                    + " ten = ?, " 
                    + " gia = ?, "
                    + " donvi = ?, " 
                    + " mota = ? "
                    + " urlanh = ?"
                + " WHERE id = ? ";

        PreparedStatementCreator psCreator = con -> {

            PreparedStatement ps = con.prepareStatement(sql);

            // điền tham số vào dấu ?
            ps.setString(1, t.getTen());
            ps.setLong(2, t.getGia());
            ps.setString(3, t.getDonvi());
            ps.setString(4, t.getMota());
            ps.setString(5, t.getUrlanh());

            ps.setLong(6, t.getId());

            return ps;
        };


        jdbcTemplate.update(psCreator);

        return this.findById(t.getId());
    }

    @Override
    public Boolean delete(Long tKey) {
        String sql = "DELETE FROM VatPham WHERE id = ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, tKey);
            return ps;
        };

        jdbcTemplate.update(psCreator);
        
        return true;
    }

}
