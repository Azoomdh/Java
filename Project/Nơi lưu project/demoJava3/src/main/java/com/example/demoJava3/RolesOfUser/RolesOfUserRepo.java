package com.example.demoJava3.RolesOfUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesOfUserRepo 
    extends JpaRepository<RolesOfUser, RolesOfUserKey>
{
    
}
