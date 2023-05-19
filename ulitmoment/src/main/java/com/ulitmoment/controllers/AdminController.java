package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AddUserDTO;
import com.ulitmoment.entities.*;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.services.CourseService;
import com.ulitmoment.services.FileService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public List<Course> courses() {
        return courseService.listCourses();
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

    @GetMapping("/user1")
    public User getUser(String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/users")
    public List<User> users() {
        return userService.userList();
    }
}