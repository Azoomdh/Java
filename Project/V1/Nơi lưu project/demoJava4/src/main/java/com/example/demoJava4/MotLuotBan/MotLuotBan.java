package com.example.demoJava4.MotLuotBan;

import java.sql.Timestamp;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class MotLuotBan 
    implements EntityInterface<MotLuotBan, Long>
{
    private Long id;
    private Timestamp thoigian;
    private Boolean dathanhToan;

    private Long KhachHangUserid;
    private Long CuaHangid;
    private Long NhanVienUserid;
    
    public MotLuotBan() {
    }

    public MotLuotBan(Long id, Timestamp thoigian, Boolean dathanhToan, Long khachHangUserid, Long cuaHangid,
            Long nhanVienUserid) {
        this.id = id;
        this.thoigian = thoigian;
        this.dathanhToan = dathanhToan;
        KhachHangUserid = khachHangUserid;
        CuaHangid = cuaHangid;
        NhanVienUserid = nhanVienUserid;
    }

    public MotLuotBan(Timestamp thoigian, Boolean dathanhToan, Long khachHangUserid, Long cuaHangid,
            Long nhanVienUserid) {
        this.thoigian = thoigian;
        this.dathanhToan = dathanhToan;
        KhachHangUserid = khachHangUserid;
        CuaHangid = cuaHangid;
        NhanVienUserid = nhanVienUserid;
    }


    
}
