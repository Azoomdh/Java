package com.example.demoJava2.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposistory 
    extends JpaRepository<User, Long>
{
    public Optional<User> findByUsername(String username);
}
