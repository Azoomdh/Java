package com.example.demoJava4.KhachHang;

import com.example.demoJava4.Interface.EntityInterface;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class KhachHang 
    implements EntityInterface<KhachHang, Long>
{
    private Long userId;

    @Override
    public void updateNotId(KhachHang o2) {
        // không làm gì cả
    }

    public KhachHang() {
    }

    public KhachHang(Long userId) {
        this.userId = userId;
    }
    
    
}
