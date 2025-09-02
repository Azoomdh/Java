package com.example.demoJava4.HoaDonNhap;

import java.sql.Timestamp;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class HoaDonNhap 
    implements EntityInterface<HoaDonNhap, Long>
{
    private Long id;
    private Timestamp thoigian;
    private Long sotien;
    private Boolean lathanhtoantienmat;
    private Long MotLuotNhapid;
    
    public HoaDonNhap() {
    }
    public HoaDonNhap(Long id, Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motLuotNhapid) {
        this.id = id;
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        MotLuotNhapid = motLuotNhapid;
    }
    public HoaDonNhap(Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motLuotNhapid) {
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        MotLuotNhapid = motLuotNhapid;
    }

    
}
