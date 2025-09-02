package com.example.demoJava4.DsspBan;

import lombok.Data;

@Data
public class DsspBanKey {
    private Long VatPhamid;
    private Long MotLuotBanid;
    
    public DsspBanKey(Long vatPhamid, Long motLuotBanid) {
        VatPhamid = vatPhamid;
        MotLuotBanid = motLuotBanid;
    }

    
}
