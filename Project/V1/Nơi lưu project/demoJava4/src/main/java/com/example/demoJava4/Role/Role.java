package com.example.demoJava4.Role;

import com.example.demoJava4.Interface.EntityInterface;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class Role 
    implements EntityInterface<Role, Long>
{
    private Long id;
    private String name;
    private String mota;
    
    // @Override
    // public void updateNotId(Role o2) {
    //     this.name = o2.getName();
    //     this.mota = o2.getMota();
    // }

    public Role(String name, String mota) {
        this.name = name;
        this.mota = mota;
    }

    public Role(Long id, String name, String mota) {
        this.id = id;
        this.name = name;
        this.mota = mota;
    }

    
}
