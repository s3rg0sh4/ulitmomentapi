package com.ulitmoment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCoreDTO {
    private Long id;
    private String email;
    private String fullname;
    private String role;
}
