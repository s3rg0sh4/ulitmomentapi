package com.ulitmoment.services;

import com.ulitmoment.entities.Role;
import com.ulitmoment.repos.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public void save(Role role) {
        roleRepo.save(role);
    }
}
