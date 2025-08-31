package com.example.demoJava4.CuaHang;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class CuaHang 
    implements EntityInterface<CuaHang, Long>
{
    private Long id;
    private String name;
    private String diachi;
    private String sodienthoai;
    private String mota;
    
    public CuaHang() {
    }

    public CuaHang(Long id, String name, String diachi, String sodienthoai, String mota) {
        this.id = id;
        this.name = name;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.mota = mota;
    }

    public CuaHang(String name, String diachi, String sodienthoai, String mota) {
        this.name = name;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.mota = mota;
    }

    
}
