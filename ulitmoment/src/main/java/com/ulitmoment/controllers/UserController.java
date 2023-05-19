package com.ulitmoment.controllers;

import com.ulitmoment.entities.User;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser() {
        User user = getCurrentUser();
        return user;
    }

    @PutMapping
    public User updUser(@RequestParam("pic")MultipartFile pic,
                           @RequestParam("about")String about,
                           @RequestParam("phone") String phone,
                           @RequestParam("birthday") Date birthday) {
        User user = getCurrentUser();
        try {
            return userService.updateUser(user, pic.getBytes(), about, phone, birthday);
        } catch (Exception e) {
            return user;
        }
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User)authentication.getPrincipal();
//        return userService.getByEmail("ulitmoment@email.com");
    }
}
