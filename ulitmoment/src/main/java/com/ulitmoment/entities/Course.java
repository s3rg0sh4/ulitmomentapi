package com.ulitmoment.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String about;

    @OneToOne
    private FileDetails pic;

    public Course(String name, String about) {
        this.name = name;
        this.about = about;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Topic> topics;

    @ManyToMany
    @JoinTable(name = "course_pupils", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "pupil_id"))
    private Set<Pupil> pupils;

    @Transactional
    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }
}