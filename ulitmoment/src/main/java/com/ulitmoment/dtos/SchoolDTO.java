package com.ulitmoment.dtos;

import com.ulitmoment.entities.Pupil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;

    private Set<Pupil> pupils;

    public SchoolDTO(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public SchoolDTO(Long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
