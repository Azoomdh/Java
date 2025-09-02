package com.example.demoJava4.DsspNhap;

import com.example.demoJava4.DsspBan.DsspBanKey;
import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class DsspNhap 
    implements EntityInterface<DsspNhap, DsspNhapKey>
{
    private DsspNhapKey dsspNhapKey;
    private Integer soluong;
    private Long gia;
    
    public DsspNhap() {
    }
    
    public DsspNhap(DsspNhapKey dsspNhapKey, Integer soluong, Long gia) {
        this.dsspNhapKey = dsspNhapKey;
        this.soluong = soluong;
        this.gia = gia;
    }

    
}
