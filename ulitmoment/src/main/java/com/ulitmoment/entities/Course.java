package com.ulitmoment.entities;

import jakarta.persistence.*;
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

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Topic> topics;

    public Course(String name, String about) {
        this.name = name;
        this.about = about;
    }

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "pupil_id"))
    private Set<Pupil> pupils;

    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }
}