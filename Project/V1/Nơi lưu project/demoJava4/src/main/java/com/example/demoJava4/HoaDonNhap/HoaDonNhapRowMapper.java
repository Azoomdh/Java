package com.example.demoJava4.HoaDonNhap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class HoaDonNhapRowMapper 
    implements RowMapper<HoaDonNhap>
{

    @Override
    @Nullable
    public HoaDonNhap mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        Long id                     = ketquatrave.getLong("id");
        Timestamp thoigian          = ketquatrave.getTimestamp("thoigian");
        Long sotien                 = ketquatrave.getLong("sotien");
        Boolean lathanhtoantienmat  = ketquatrave.getBoolean("lathanhtoantienmat");
        Long MotLuotNhapid          = ketquatrave.getLong("MotLuotNhapid");
        
        HoaDonNhap hoadonnhap1 = new HoaDonNhap(id, thoigian, sotien, lathanhtoantienmat, MotLuotNhapid);
        
        return hoadonnhap1;
    }
    
}
