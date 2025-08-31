package com.example.demoJava4.NhaCungCap;

import com.example.demoJava4.Interface.EntityInterface;

import lombok.Data;

@Data
public class NhaCungCap 
    implements EntityInterface<NhaCungCap, Long>
{
    private Long id;
    private String name;
    private String address;
    private String sodienthoai;
    private String email;
    private String mota;

    public NhaCungCap() {
    }
    public NhaCungCap(Long id, String name, String address, String sodienthoai, String email, String mota) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.mota = mota;
    }
    public NhaCungCap(String name, String address, String sodienthoai, String email, String mota) {
        this.name = name;
        this.address = address;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.mota = mota;
    }
    // @Override
    // public void updateNotId(NhaCungCap o2) {
    //     this.name = o2.getName();
    //     this.address = o2.getAddress();
    //     this.sodienthoai = o2.getSodienthoai();
    //     this.email = o2.getEmail();
    //     this.mota = o2.getMota();
    // }

    
}
