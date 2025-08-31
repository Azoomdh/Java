package com.example.demoJava4.DsspNhap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class DsspNhapRowMapper 
    implements RowMapper<DsspNhap>
{

    @Override
    @Nullable
    public DsspNhap mapRow(ResultSet ketquatrave, int stthang) throws SQLException {
        Long MotLuotNhapid = ketquatrave.getLong("MotLuotNhapid");
        Long VatPhamid = ketquatrave.getLong("VatPhamid");
        Integer soluong = ketquatrave.getInt("soluong");
        Long gia = ketquatrave.getLong("gia");

        DsspNhapKey dsspNhapKey = new DsspNhapKey(MotLuotNhapid, VatPhamid);

        DsspNhap dsspNhap = new DsspNhap(dsspNhapKey, soluong, gia);

        return dsspNhap;
    }
    
}
