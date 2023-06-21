package com.ulitmoment.services;

import com.ulitmoment.entities.Course;
import com.ulitmoment.entities.Pupil;
import com.ulitmoment.entities.User;
import com.ulitmoment.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private FileService fileService;

    public List<User> userList(Course course) {
        List pupils = course.getPupils().stream().toList();

        return pupils;
    }

    public Long addPupilToCourse(Course course, Pupil pupil) {
        HashSet<Pupil> pupils = new HashSet<>(course.getPupils());
        pupils.add(pupil);
        course.setPupils(pupils);
        courseRepo.save(course);
        return pupils.stream().count();
    }

    public void addCourse(String name, String about, MultipartFile pic) {
        Course course = courseRepo.save(new Course(name, about));
        fileService.save(pic, course);
    }

    public List<Course> listCourses() {
        List<Course> courses = courseRepo.findAll();

        return courses;
    }
}
