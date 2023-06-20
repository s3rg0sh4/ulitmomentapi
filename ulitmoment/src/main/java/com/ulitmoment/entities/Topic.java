package com.ulitmoment.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="topics")
@Data
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String summary;
    private String task;
    private String hint;

    @ManyToOne
    private Course course;

    @OneToMany
    private Set<Exercise> exercises;
}
