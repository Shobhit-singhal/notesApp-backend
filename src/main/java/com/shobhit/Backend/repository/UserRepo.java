package com.shobhit.Backend.repository;

import com.shobhit.Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String username);
}
