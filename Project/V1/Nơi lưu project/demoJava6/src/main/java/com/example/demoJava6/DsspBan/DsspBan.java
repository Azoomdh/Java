package com.example.demoJava6.DsspBan;

import lombok.Data;

@Data
public class DsspBan {

    private DsspBanId id;
    private Integer soluong;
    private Long gia;

    public DsspBan() {
    }
    
    public DsspBan(DsspBanId id, Integer soluong, Long gia) {
        this.id = id;
        this.soluong = soluong;
        this.gia = gia;
    }

    
}
