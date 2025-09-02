package com.example.demoJava3.KhachHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo 
    extends JpaRepository<KhachHang, Long>
{

}
