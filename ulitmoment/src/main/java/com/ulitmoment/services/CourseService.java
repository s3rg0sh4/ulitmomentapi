package com.ulitmoment.services;

import com.ulitmoment.entities.Course;
import com.ulitmoment.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

//    public void addPupilToCourse(Course course, Pupil pupil) {
//        courseRepo.addPupilToCourse(course.getId(), pupil);
//    }

    public void addCourse(String name, String about, byte[] pic) {
        courseRepo.save(new Course(name, about, pic));
    }

    public List<Course> listCourses() {
        return courseRepo.findAll();
    }
}
