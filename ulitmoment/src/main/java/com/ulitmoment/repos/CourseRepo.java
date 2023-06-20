package com.ulitmoment.repos;

import com.ulitmoment.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

}