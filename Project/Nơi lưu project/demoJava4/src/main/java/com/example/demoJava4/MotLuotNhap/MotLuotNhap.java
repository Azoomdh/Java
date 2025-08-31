package com.example.demoJava4.MotLuotNhap;

import java.sql.Timestamp;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class MotLuotNhap 
    implements EntityInterface<MotLuotNhap, Long>
{
    private Long id;
    private Timestamp thoigian;
    private Boolean dathanhtoan;
    
    private Long NhaCungCapid;
    private Long CuaHangid;
    private Long NhanVienUserid;
    
    public MotLuotNhap() {
    }
    public MotLuotNhap(Long id, Timestamp thoigian, Boolean dathanhtoan, Long nhaCungCapid, Long cuaHangid,
            Long nhanVienUserid) {
        this.id = id;
        this.thoigian = thoigian;
        this.dathanhtoan = dathanhtoan;
        NhaCungCapid = nhaCungCapid;
        CuaHangid = cuaHangid;
        NhanVienUserid = nhanVienUserid;
    }
    public MotLuotNhap(Timestamp thoigian, Boolean dathanhtoan, Long nhaCungCapid, Long cuaHangid,
            Long nhanVienUserid) {
        this.thoigian = thoigian;
        this.dathanhtoan = dathanhtoan;
        NhaCungCapid = nhaCungCapid;
        CuaHangid = cuaHangid;
        NhanVienUserid = nhanVienUserid;
    }

    
}
