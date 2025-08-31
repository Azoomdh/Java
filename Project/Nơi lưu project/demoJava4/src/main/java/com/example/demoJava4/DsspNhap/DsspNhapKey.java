package com.example.demoJava4.DsspNhap;

import lombok.Data;

@Data
public class DsspNhapKey {
    private Long MotLuotNhapid;
    private Long VatPhamid;
    
    public DsspNhapKey(Long motLuotNhapid, Long vatPhamid) {
        MotLuotNhapid = motLuotNhapid;
        VatPhamid = vatPhamid;
    }

    
}
