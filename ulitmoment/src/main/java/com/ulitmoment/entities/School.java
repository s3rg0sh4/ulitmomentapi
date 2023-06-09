package com.ulitmoment.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "schools")
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;

    @OneToMany
    private Set<Pupil> pupils;

    public School(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public School(String name) {
        this.name = name;
    }

    public void addPupil(Pupil pupil) {
        this.pupils.add(pupil);
    }
}
