package com.ulitmoment.services;

import com.ulitmoment.entities.Course;
import com.ulitmoment.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private FileService fileService;

//    public void addPupilToCourse(Course course, Pupil pupil) {
//        courseRepo.addPupilToCourse(course.getId(), pupil);
//    }

    public void addCourse(String name, String about, MultipartFile pic) {
        Course course = courseRepo.save(new Course(name, about));
        fileService.save(pic, course);
    }

    public List<Course> listCourses() {
        List<Course> courses = courseRepo.findAll();

        return courses;
    }
}
