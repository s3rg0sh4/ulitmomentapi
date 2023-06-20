package com.ulitmoment.repos;

import com.ulitmoment.entities.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PupilRepo extends JpaRepository<Pupil, Long> {
    Pupil findByEmail(String email);
}