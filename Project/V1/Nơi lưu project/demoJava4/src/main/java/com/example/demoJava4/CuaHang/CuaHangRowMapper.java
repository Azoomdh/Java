package com.example.demoJava4.CuaHang;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class CuaHangRowMapper 
    implements RowMapper<CuaHang>
{

    @Override
    @Nullable
    public CuaHang mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long id             = ketQuaTraVe.getLong("id");
        String name         = ketQuaTraVe.getString("name");
        String diachi       = ketQuaTraVe.getString("diachi");
        String sodienthoai  = ketQuaTraVe.getString("sodienthoai");
        String mota         = ketQuaTraVe.getString("mota");

        CuaHang ch1 = new CuaHang(id, name, diachi, sodienthoai, mota);
        return ch1;
    }
    
}
