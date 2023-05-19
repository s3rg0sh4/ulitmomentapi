package com.ulitmoment.repos;

import com.ulitmoment.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
