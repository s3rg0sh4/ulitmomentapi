package com.ulitmoment.config;

import com.ulitmoment.entities.*;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.repos.CourseRepo;
import com.ulitmoment.repos.FileSystemRepo;
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
    private FileSystemRepo fileSystemRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepo courseRepo;

    public void run(ApplicationArguments args) {
        fileSystemRepo.init();
        roleService.save(new Role(Roles.ROLE_PUPIL));
        roleService.save(new Role(Roles.ROLE_CURATOR));
        roleService.save(new Role(Roles.ROLE_TEACHER));
        roleService.save(new Role(Roles.ROLE_ADMIN));
        userService.saveUser(new Admin("ulitmoment@gmail.com", "ulit", "Амогус", "Импостер", "Мафиозович"), Roles.ROLE_ADMIN);
        userService.saveUser(new Pupil("s3rg0sh4@gmail.com", "123", "Школьников", "Школьник", "Школьникович"), Roles.ROLE_PUPIL);

    }
}