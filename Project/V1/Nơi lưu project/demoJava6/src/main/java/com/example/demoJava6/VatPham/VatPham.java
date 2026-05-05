package com.example.demoJava6.VatPham;

import lombok.Data;

@Data
public class VatPham {

    private Long id;
    private String ten;
    private Long gia;
    private String donvi;
    private String mota;
    private String urlanh;
    private Integer soluong;
    
    public VatPham() {
    }
    public VatPham(Long id, String ten, Long gia, String donvi, String mota, String urlanh, Integer soluong) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
        this.urlanh = urlanh;
        this.soluong = soluong;
    }

    
}
