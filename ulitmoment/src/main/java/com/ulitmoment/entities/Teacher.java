package com.ulitmoment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Transactional
@NoArgsConstructor
public class Teacher extends User {
    private String university;


    @ManyToMany
    private Set<Course> courses;

    public Teacher(String email) {
        super(email);
    }

    public Teacher(String email, String surname, String name, String patronymic) {
        super(email, surname, name, patronymic);
    }
}