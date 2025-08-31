package com.example.demoJava4.MotLuotNhap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class MotLuotNhapRowMapper 
    implements RowMapper<MotLuotNhap>
{

    @Override
    @Nullable
    public MotLuotNhap mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        Long id = ketquatrave.getLong("id");
        Timestamp thoigian = ketquatrave.getTimestamp("thoigian");
        Boolean dathanhtoan = ketquatrave.getBoolean("dathanhtoan");
        Long NhaCungCapid = ketquatrave.getLong("NhaCungCapid");
        Long CuaHangid = ketquatrave.getLong("CuaHangid");
        Long NhanVienUserid = ketquatrave.getLong("NhanVienUserid");

        MotLuotNhap motLuotNhap = new MotLuotNhap(id, thoigian, dathanhtoan, NhaCungCapid, CuaHangid, NhanVienUserid);
        
        return motLuotNhap;
    }
    
}
