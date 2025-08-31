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
        String donvicua1sanpham = ketquatrave.getString("donvicua1sanpham");
        String mota = ketquatrave.getString("mota");

        VatPham vatPham1 = new VatPham(id, ten, gia, donvicua1sanpham, mota);

        return vatPham1;
    }
    
}
