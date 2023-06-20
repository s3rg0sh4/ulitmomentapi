package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AddPupilDTO;
import com.ulitmoment.dtos.CourseDTO;
import com.ulitmoment.entities.Course;
import com.ulitmoment.entities.Pupil;
import com.ulitmoment.entities.User;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.repos.CourseRepo;
import com.ulitmoment.repos.PupilRepo;
import com.ulitmoment.services.CourseService;
import com.ulitmoment.services.FileService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private PupilRepo pupilRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

//    @GetMapping
//    public List<Course> CourseList() {
//        return courseService.listCourses();
//    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> courses(Long userId) {
        List<Course> courses = new ArrayList<>();
        User user = userService.getById(userId);
        switch (Roles.valueOf(user.getRole().getName())) {
            case ROLE_PUPIL -> courses = pupilRepo.findById(userId).get().getCourses().stream().toList();
            case ROLE_ADMIN -> courses = courseService.listCourses();
            case ROLE_TEACHER -> courses = courseService.listCourses();
            case ROLE_CURATOR -> courses = courseService.listCourses();
        }

//        courses = pupilRepo.findById(userId).get().getCourses();

        List<CourseDTO> courseList = new ArrayList<>();
        courses.stream().forEach(course -> {
            Resource pic = fileService.get(course);
            courseList.add(new CourseDTO(course.getId(), course.getName(), course.getAbout(), pic));
        });

        return ResponseEntity.ok()
                .body(courseList);
    }

    @PutMapping
    public ResponseEntity addPupil(AddPupilDTO dto) {
        Pupil pupil = pupilRepo.findById(dto.getPupilId()).get();
        Course course = courseRepo.findById(dto.getCourseId()).get();
        courseService.addPupilToCourse(course, pupil);

        return ResponseEntity.ok().body(null);
    }

    @PostMapping
    public void createCourse(@RequestParam("pic") MultipartFile pic, @RequestParam("name") String name, @RequestParam("about") String about) {
        try {
            courseService.addCourse(name, about, pic);
        } catch (Exception e) {
        }
    }
}
