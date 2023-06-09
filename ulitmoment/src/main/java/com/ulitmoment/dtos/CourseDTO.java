package com.ulitmoment.dtos;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
public class CourseDTO {
    private Long id;
    private String name;
    private String about;
    private String pic;

    public CourseDTO(Long id, String name, String about, Resource imageResource) {
        this.id = id;
        this.name = name;
        this.about = about;

        try {
            byte[] imageBytes = StreamUtils.copyToByteArray(imageResource.getInputStream());
            this.pic = new String(Base64.getEncoder().encode(imageBytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
        }
    }
}
