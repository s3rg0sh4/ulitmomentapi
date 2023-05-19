package com.ulitmoment.controllers;

import com.ulitmoment.entities.Course;
import com.ulitmoment.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> CourseList() {
        return courseService.listCourses();
    }

    @PostMapping
    public void CreateCourse(@RequestParam("pic") MultipartFile pic, @RequestParam("name") String name, @RequestParam("about") String about) {
        try {
            courseService.addCourse(name, about, pic.getBytes());
        } catch (Exception e) {

        }
    }
}
