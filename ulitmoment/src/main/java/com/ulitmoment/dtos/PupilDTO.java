package com.ulitmoment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.Resource;

@AllArgsConstructor
@Data
public class PupilDTO extends UserDTO {
    private short grade;

    public PupilDTO(Long id, String email, String fullname, String role, String about, String phone, Resource imageResource) {
        super(id, email, fullname, role, about, phone, imageResource);
    }
}
