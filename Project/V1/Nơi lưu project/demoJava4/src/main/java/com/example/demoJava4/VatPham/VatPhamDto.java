package com.example.demoJava4.VatPham;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class VatPhamDto {

    private String ten;
    private Long gia;
    private String donvi;
    private String mota;
    private MultipartFile anh;
    public VatPhamDto(String ten, Long gia, String donvi, String mota, MultipartFile anh) {
        this.ten = ten;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
        this.anh = anh;
    }
    public VatPhamDto() {
    }


    
}
