package com.ulitmoment.repos;

import com.ulitmoment.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Course c SET c.pupils = :pupil WHERE c.id = :courseId")
//    void addPupilToCourse(Long courseId, Pupil pupil);
}
//INSERT INTO public.course_pupils(course_id, pupils_id)
//	VALUES (?, ?)