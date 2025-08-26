package com.example.demoJava3.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UsersRepo 
    extends JpaRepository<Users, Long>
{
    public List<Users> findByUsername(String username);
}
