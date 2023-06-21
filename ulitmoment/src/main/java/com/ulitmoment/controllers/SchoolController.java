package com.ulitmoment.controllers;

import com.ulitmoment.dtos.SchoolDTO;
import com.ulitmoment.entities.School;
import com.ulitmoment.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/addSchool")
    public ResponseEntity addSchool(@RequestBody SchoolDTO school) {
        schoolService.addSchool(new School(school.getName(), school.getAddress(), school.getPhone()));


        return ResponseEntity.ok().body(null);
    }


}
