package com.ulitmoment.dtos;

import lombok.Data;

@Data
public class AddUserDTO {
    String email;
    String role;
    String surname;
    String name;
    String patronymic;
}
