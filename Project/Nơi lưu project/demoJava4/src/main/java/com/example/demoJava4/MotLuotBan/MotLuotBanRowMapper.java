package com.example.demoJava4.MotLuotBan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class MotLuotBanRowMapper 
    implements RowMapper<MotLuotBan>
{

    @Override
    @Nullable
    public MotLuotBan mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        Long id = ketquatrave.getLong("id");
        Timestamp thoigian = ketquatrave.getTimestamp("thoigian");
        Boolean dathanhtoan = ketquatrave.getBoolean("dathanhtoan");
        Long CuaHangid = ketquatrave.getLong("CuaHangid");
        Long KhachHangUserid = ketquatrave.getLong("KhachHangUserid");
        Long NhanVienUserid = ketquatrave.getLong("NhanVienUserid");

        MotLuotBan motLuotBan = new MotLuotBan(id, thoigian, dathanhtoan, KhachHangUserid, CuaHangid, NhanVienUserid);
        
        return motLuotBan;
    }
    
}
