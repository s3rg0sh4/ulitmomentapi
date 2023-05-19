package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AuthDTO;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class SignInController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Boolean getUser(@RequestBody AuthDTO dto) {
        return userService.userCheck(dto.getEmail(), dto.getPassword());
    }
}
