package com.example.demoJava6.MotLuotBan;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MotLuotBan {

    private Long id;
    private Timestamp thoigian;
    private Boolean dathanhtoan;
    private Long UseridKhachhang;
    public MotLuotBan() {
    }
    public MotLuotBan(Long id, Timestamp thoigian, Boolean dathanhtoan, Long useridKhachhang) {
        this.id = id;
        this.thoigian = thoigian;
        this.dathanhtoan = dathanhtoan;
        UseridKhachhang = useridKhachhang;
    }

    
}
