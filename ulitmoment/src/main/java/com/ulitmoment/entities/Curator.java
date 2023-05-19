package com.ulitmoment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "curators")
@Transactional
@NoArgsConstructor
public class Curator extends User {
//    private String group;

    @OneToMany
    private Set<Pupil> pupils;

    public Curator(String email) {
        super(email);
    }

    public Curator(String email, String surname, String name, String patronymic) {
        super(email, surname, name, patronymic);
    }
//    @OneToMany
//    private Set<Pupil> pupils;
}
