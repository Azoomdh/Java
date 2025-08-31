package com.example.demoJava4.HoaDonBan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class HoaDonBanRowMapper
    implements RowMapper<HoaDonBan>
{

    @Override
    @Nullable
    public HoaDonBan mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        Long id = ketquatrave.getLong("id");
        Timestamp thoigian = ketquatrave.getTimestamp("thoigian");
        Long sotien = ketquatrave.getLong("sotien");
        Boolean lathanhtoantienmat = ketquatrave.getBoolean("lathanhtoantienmat");

        Long MotLuotBanid = ketquatrave.getLong("MotLuotBanid");

        HoaDonBan hoadonban1 = new HoaDonBan(id, thoigian, sotien, lathanhtoantienmat, MotLuotBanid);
        
        return hoadonban1; 
    }
    
}
