package com.example.demoJava6.Role;

import lombok.Data;

@Data
public class Role {

    private Long id;
    private String name;
    private String mota;

    public Role() {
    }

    public Role(Long id, String name, String mota) {
        this.id = id;
        this.name = name;
        this.mota = mota;
    }

    
}
