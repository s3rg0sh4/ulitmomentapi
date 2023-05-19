package com.ulitmoment.repos;

import com.ulitmoment.entities.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
