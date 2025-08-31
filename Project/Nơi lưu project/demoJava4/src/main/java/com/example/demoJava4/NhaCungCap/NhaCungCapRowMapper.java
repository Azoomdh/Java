package com.example.demoJava4.NhaCungCap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class NhaCungCapRowMapper 
    implements RowMapper<NhaCungCap>
{

    @Override
    @Nullable
    public NhaCungCap mapRow(ResultSet ketquatrave, int sttHang) throws SQLException {
        Long id = ketquatrave.getLong("id");
        String name = ketquatrave.getString("name");
        String address = ketquatrave.getString("address");
        String sodienthoai = ketquatrave.getString("sodienthoai");
        String email = ketquatrave.getString("email");
        String mota = ketquatrave.getString("mota");
        
        NhaCungCap ncc1 = new NhaCungCap(id, name, address, sodienthoai, email, mota);

        return ncc1;
    }

}
