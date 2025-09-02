package com.example.demoJava4.NhanVien;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class NhanVienRowMapper 
    implements RowMapper<NhanVien>
{

    @Override
    @Nullable
    public NhanVien mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long userId = ketQuaTraVe.getLong("Userid");

        NhanVien nv1 = new NhanVien(userId);

        return nv1;
    }
    
}
