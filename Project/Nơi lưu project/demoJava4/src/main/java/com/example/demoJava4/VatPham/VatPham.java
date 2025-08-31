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
    private String donvicua1sanpham;
    private String mota;
    
    public VatPham() {
    }
    public VatPham(Long id, String ten, Long gia, String donvicua1sanpham, String mota) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.donvicua1sanpham = donvicua1sanpham;
        this.mota = mota;
    }
    public VatPham(String ten, Long gia, String donvicua1sanpham, String mota) {
        this.ten = ten;
        this.gia = gia;
        this.donvicua1sanpham = donvicua1sanpham;
        this.mota = mota;
    }

    
}
