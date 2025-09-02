package com.example.demoJava4.NhanVien;

import com.example.demoJava4.Interface.EntityInterface;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class NhanVien 
    implements EntityInterface<NhanVien, Long>
{
    private Long userId;

    // @Override
    // public void updateNotId(NhanVien o2) {
    //     // không làm gì cả        
    // }

    public NhanVien() {
    }

    public NhanVien(Long userId) {
        this.userId = userId;
    }
    
    
}
