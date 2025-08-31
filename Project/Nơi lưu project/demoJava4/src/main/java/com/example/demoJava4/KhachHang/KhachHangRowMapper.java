package com.example.demoJava4.KhachHang;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class KhachHangRowMapper 
    implements RowMapper<KhachHang>
{

    @Override
    @Nullable
    public KhachHang mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long userId = ketQuaTraVe.getLong("Userid");
        KhachHang kh1 = new KhachHang(userId);
        return kh1;
    }
    
}
