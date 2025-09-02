package com.example.demoJava4.VatPham;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class VatPham 
    implements EntityInterface<VatPham, Long>
{
    private Long id;
    private String ten;
    private Long gia;
    private String donvi;
    private String mota;
    private String urlanh;
    
    public VatPham() {
    }
    public VatPham(Long id, String ten, Long gia, String donvi, String mota, String urlanh) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
        this.urlanh = urlanh;
    }
    public VatPham(String ten, Long gia, String donvi, String mota, String urlanh) {
        this.ten = ten;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
        this.urlanh = urlanh;
    }

    
}
