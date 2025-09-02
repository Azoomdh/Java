package com.example.demoJava4.VatPham;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class VatPhamRowMapper 
    implements RowMapper<VatPham>
{

    @Override
    @Nullable
    public VatPham mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        
        Long id = ketquatrave.getLong("id");
        String ten = ketquatrave.getString("ten");
        Long gia = ketquatrave.getLong("gia");
        String donvi = ketquatrave.getString("donvi");
        String mota = ketquatrave.getString("mota");
        String urlanh = ketquatrave.getString("urlanh");

        VatPham vatPham1 = new VatPham(id, ten, gia, donvi, mota, urlanh);

        return vatPham1;
    }
    
}
