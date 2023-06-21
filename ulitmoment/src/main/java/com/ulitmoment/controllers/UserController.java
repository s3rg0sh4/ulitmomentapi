package com.ulitmoment.controllers;

import com.ulitmoment.dtos.AuthDTO;
import com.ulitmoment.dtos.UserDTO;
import com.ulitmoment.entities.User;
import com.ulitmoment.services.FileService;
import com.ulitmoment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

//    @GetMapping
//    public ResponseEntity<UserDTO> user(Long userId) {
//        User user = userService.getById(userId);
//        return ResponseEntity.ok().body(new UserDTO(user, fileService.get(user)));
//    }

    @PostMapping("setPassword")
    public ResponseEntity setPassword(@RequestBody AuthDTO dto) {
        User user = userService.getByEmail(dto.getEmail());
        userService.setUserPassword(user, dto.getPassword());
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("getUserById")
    public ResponseEntity<UserDTO> getUserById(@RequestParam String id) {
        User user = userService.getById(Long.parseLong(id));

        UserDTO dto = new UserDTO(user.getId(),
                user.getEmail(), user.getFullname(),
                user.getRole().getName(), user.getAbout(),
                user.getPhone(), fileService.get(user)
        );

        return ResponseEntity.ok()
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser() {
        User user = getCurrentUser();

        UserDTO dto = new UserDTO(user.getId(),
                user.getEmail(), user.getFullname(),
                user.getRole().getName(), user.getAbout(),
                user.getPhone(), fileService.get(user)
        );

        return ResponseEntity.ok()
                .body(dto);
    }

//    @GetMapping("avatar")
//    public ResponseEntity<Resource> getAvatar() {
//        User user = getCurrentUser();
//        try {
//            return ResponseEntity.ok()
//                    .body(fileService.get(user));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @PutMapping("avatar")
//    public void updAvatar(@RequestParam("pic")MultipartFile pic) {
//        User user = getCurrentUser();
//        try {
//            fileService.save(pic, user);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @PostMapping
    public ResponseEntity updUser(@RequestParam("about") String about,
                        @RequestParam("phone") String phone,
                        @RequestParam("pic") MultipartFile pic) {
        User user = getCurrentUser();
        try {
            userService.updateUser(user, about, phone, user.getBirthday());
            fileService.save(pic, user);
            return ResponseEntity.ok().body(null);
//            return userService.updateUser(user, about, phone, user.getBirthday());
        } catch (Exception e) {
//            return user;
            return ResponseEntity.badRequest().body(null);

        }
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
//        return userService.getByEmail("ulitmoment@email.com");
    }
}
