package com.example.demoJava6.DsspBan;

import lombok.Data;

@Data
public class DsspBanId {
    private Long VatPhamid;
    private Long MotLuotBanid;

    public DsspBanId() {
    }
    
    public DsspBanId(Long vatPhamid, Long motLuotBanid) {
        VatPhamid = vatPhamid;
        MotLuotBanid = motLuotBanid;
    }

    
}
