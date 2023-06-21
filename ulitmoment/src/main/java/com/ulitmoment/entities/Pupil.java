package com.ulitmoment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Transactional
@NoArgsConstructor
public class Pupil extends User {
    private short grade;

    @ManyToOne
    private School school;

    @ManyToOne
    private Curator curator;

    @ManyToMany
    private Set<Course> courses;

    @ManyToMany
    private Set<Exercise> exercises;

//    @ManyToMany
//    private Set<Homework> homeworks;

    public Pupil(String email) {
        super(email);
    }

    public Pupil(String email, String surname, String name, String patronymic) {
        super(email, surname, name, patronymic);
    }
    public Pupil(String email, String password, String surname, String name, String patronymic) {
        super(email, password, surname, name, patronymic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(this.getEmail(), pupil.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getEmail());
    }
}
