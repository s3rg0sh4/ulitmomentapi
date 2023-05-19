package com.ulitmoment.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin extends User {

    public Admin(String email, String password) {
        super(email, password);
    }
    public Admin(String email) {
        super(email);
    }

    public Admin(String email, String surname, String name, String patronymic) {
        super(email, surname, name, patronymic);
    }

    public Admin(String email, String password, String surname, String name, String patronymic) {
        super(email, password, surname, name, patronymic);
    }
}
