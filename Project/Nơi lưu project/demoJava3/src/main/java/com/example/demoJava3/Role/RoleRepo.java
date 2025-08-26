package com.example.demoJava3.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo 
    extends JpaRepository<Role, Long>
{
    public List<Role> findByName(String name);
}
