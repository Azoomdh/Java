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

    public KhachHang() {
    }

    public KhachHang(Long userId) {
        this.userId = userId;
    }
    
    
}
