package com.example.demoJava4.DsspBan;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class DsspBan 
    implements EntityInterface<DsspBan, DsspBanKey>
{
    private DsspBanKey dsspBanKey;
    private Integer soluong;
    private Long gia;

    public DsspBan() {
    }

    public DsspBan(DsspBanKey dsspBanKey, Integer soluong, Long gia) {
        this.dsspBanKey = dsspBanKey;
        this.soluong = soluong;
        this.gia = gia;
    }

    
}
