package com.ulitmoment.controllers;

import com.ulitmoment.dtos.UserDTO;
import com.ulitmoment.entities.User;
import com.ulitmoment.services.FileService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pupil")
public class PupilController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;



    @GetMapping
    public ResponseEntity<UserDTO> getPupil(Long id) {
        User user = userService.getById(id);

        UserDTO dto = new UserDTO(user.getId(),
                user.getEmail(), user.getFullname(),
                user.getRole().getName(), user.getAbout(),
                user.getPhone(), fileService.get(user)
        );

        return ResponseEntity.ok()
                .body(dto);
    }


//    private User getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (User)authentication.getPrincipal();
//    }
}
