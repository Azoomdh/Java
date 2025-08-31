package com.example.demoJava4.HoaDonBan;

import java.sql.Timestamp;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class HoaDonBan 
    implements EntityInterface<HoaDonBan, Long>
{
    private Long id;
    private Timestamp thoigian;
    private Long sotien;
    private Boolean lathanhtoantienmat;
    private Long MotLuotBanid;
    
    public HoaDonBan() {
    }
    public HoaDonBan(Long id, Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motLuotBanid) {
        this.id = id;
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        MotLuotBanid = motLuotBanid;
    }
    public HoaDonBan(Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motLuotBanid) {
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        MotLuotBanid = motLuotBanid;
    }

    
}
