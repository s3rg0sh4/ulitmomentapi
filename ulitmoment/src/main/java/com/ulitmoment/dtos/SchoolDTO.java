package com.ulitmoment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;

    public SchoolDTO(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


}
