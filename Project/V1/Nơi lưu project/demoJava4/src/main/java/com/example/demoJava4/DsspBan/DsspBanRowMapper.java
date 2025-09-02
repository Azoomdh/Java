package com.example.demoJava4.DsspBan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class DsspBanRowMapper 
    implements RowMapper<DsspBan>
{

    @Override
    @Nullable
    public DsspBan mapRow(ResultSet ketQuaTraVe, int sttHang) throws SQLException {
        Long VatPhamid      = ketQuaTraVe.getLong("VatPhamid");
        Long MotLuotBanid   = ketQuaTraVe.getLong("MotLuotBanid");
        Integer soluong     = ketQuaTraVe.getInt("soluong");
        Long gia            = ketQuaTraVe.getLong("gia");

        DsspBanKey dsspBanKey = new DsspBanKey(VatPhamid, MotLuotBanid);

        DsspBan dsspBan = new DsspBan(dsspBanKey, soluong, gia);

        return dsspBan;
    }
    
}
