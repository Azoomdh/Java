package com.example.demoJava3.KhachHang;

import com.example.demoJava3.User.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class KhachHang 
    extends Users
{
    public KhachHang(Users user1){
        this.setMaUser(user1.getMaUser());
        this.setUsername(user1.getUsername());
        this.setPassword(user1.getPassword());
        this.setTen(user1.getTen());
        this.setEmail(user1.getEmail());
        this.setSodienthoai(user1.getSodienthoai());
        this.setEnabled(user1.getEnabled());
    }
    
}
