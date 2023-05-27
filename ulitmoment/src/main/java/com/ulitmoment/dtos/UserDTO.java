package com.ulitmoment.dtos;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String fullname;
    private String role;
    private String about;
    private String phone;
    private String pic;

    public UserDTO(Long id, String email, String fullname, String role, String about, String phone, Resource imageResource) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.about = about;
        this.phone = phone;

        try {
            byte[] imageBytes = StreamUtils.copyToByteArray(imageResource.getInputStream());
            this.pic = new String(Base64.getEncoder().encode(imageBytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
        }
    }
}
