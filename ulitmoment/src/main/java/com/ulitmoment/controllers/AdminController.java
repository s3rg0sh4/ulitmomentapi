package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AddUserDTO;
import com.ulitmoment.dtos.CourseDTO;
import com.ulitmoment.dtos.UserCoreDTO;
import com.ulitmoment.entities.Admin;
import com.ulitmoment.entities.Curator;
import com.ulitmoment.entities.Pupil;
import com.ulitmoment.entities.Teacher;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.services.CourseService;
import com.ulitmoment.services.FileService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> courses() {
        List<CourseDTO> courseList = new ArrayList<>();
        courseService.listCourses().stream().forEach(course -> {
            Resource pic = fileService.get(course);
            courseList.add(new CourseDTO(course.getId(), course.getName(), course.getAbout(), pic));
        });

        return ResponseEntity.ok()
                .body(courseList);
    }

    @PostMapping("/signon")
    public void signon(@RequestBody AddUserDTO dto) {
        switch (Roles.valueOf(dto.getRole())) {
            case ROLE_ADMIN -> userService.saveUser(new Admin(dto.getEmail(), dto.getSurname(), dto.getName(), dto.getPatronymic()), Roles.valueOf(dto.getRole()));
            case ROLE_TEACHER -> userService.saveUser(new Teacher(dto.getEmail(), dto.getSurname(), dto.getName(), dto.getPatronymic()), Roles.valueOf(dto.getRole()));
            case ROLE_CURATOR -> userService.saveUser(new Curator(dto.getEmail(), dto.getSurname(), dto.getName(), dto.getPatronymic()), Roles.valueOf(dto.getRole()));
            case ROLE_PUPIL -> userService.saveUser(new Pupil(dto.getEmail(), dto.getSurname(), dto.getName(), dto.getPatronymic()), Roles.valueOf(dto.getRole()));
        }
    }

    @GetMapping("/users")
    public List<UserCoreDTO> users() {
        List<UserCoreDTO> userList = new ArrayList<>();
        userService.userList().stream().forEach(user -> {
            Resource pic = fileService.get(user);
            userList.add(new UserCoreDTO(user.getId(), user.getEmail(), user.getFullname(), user.getRole().getName()));
        });

        return userList;
    }
}