package com.ulitmoment.controllers;

import com.ulitmoment.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

//    @GetMapping
//    public List<Course> CourseList() {
//        return courseService.listCourses();
//    }

    @PostMapping
    public void CreateCourse(@RequestParam("pic") MultipartFile pic, @RequestParam("name") String name, @RequestParam("about") String about) {
        try {
            courseService.addCourse(name, about, pic);
        } catch (Exception e) {
        }
    }
}
