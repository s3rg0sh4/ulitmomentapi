package com.ulitmoment.config;

import com.ulitmoment.entities.*;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.repos.CourseRepo;
import com.ulitmoment.repos.FileRepo;
import com.ulitmoment.repos.UserRepo;
import com.ulitmoment.services.CourseService;
import com.ulitmoment.services.RoleService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderConfig implements ApplicationRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private FileRepo fileRepo;
    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private UserRepo userRepo;

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepo courseRepo;

    public void run(ApplicationArguments args) {
        fileRepo.init();
        roleService.save(new Role(Roles.ROLE_PUPIL));
        roleService.save(new Role(Roles.ROLE_CURATOR));
        roleService.save(new Role(Roles.ROLE_TEACHER));
        roleService.save(new Role(Roles.ROLE_ADMIN));
        userService.saveUser(new Admin("ulitmoment@gmail.com", "ulit", "Амогус", "Импостер", "Мафиозович"), Roles.ROLE_ADMIN);
//        userService.saveUser(new Pupil("aaaa"), Roles.ROLE_ADMIN);

//        courseRepo.save(new Course());
//        Course course = courseRepo.findById(1L).get();
//        Pupil pupil = (Pupil)userRepo.findById(2L).get();
//        courseService.addPupilToCourse(course, pupil);
    }
}