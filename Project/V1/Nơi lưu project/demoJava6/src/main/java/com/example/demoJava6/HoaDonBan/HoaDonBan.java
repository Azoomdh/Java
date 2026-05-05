package com.example.demoJava6.HoaDonBan;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class HoaDonBan {

    private Long id;
    private Timestamp thoigian;
    private Long sotien;
    private Boolean lathanhtoantienmat;
    private Long Motluotbanid;
    public HoaDonBan() {
    }
    public HoaDonBan(Long id, Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motluotbanid) {
        this.id = id;
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        Motluotbanid = motluotbanid;
    }

    
}
