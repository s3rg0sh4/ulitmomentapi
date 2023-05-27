package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AuthDTO;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class SignInController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO dto) {
        if (userService.userCheck(dto.getEmail(), dto.getPassword())) {
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }
}
