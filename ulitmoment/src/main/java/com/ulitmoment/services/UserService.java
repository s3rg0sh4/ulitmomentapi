package com.ulitmoment.services;

import com.ulitmoment.entities.User;
import com.ulitmoment.enums.Roles;
import com.ulitmoment.repos.RoleRepo;
import com.ulitmoment.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    FileService fileService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User updateUser(User user, String about, String phone, Date birthday) {
        user.setAbout(about);
        user.setPhone(phone);
        user.setBirthday(birthday);
        userRepo.save(user);
        return user;
    }

    public boolean userCheck(String email, String password) {
        User user = userRepo.findByEmail(email);
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public User getById(Long id) {
        User user = userRepo.findById(id).get();

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User getByEmail(String email) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<User> userList() {
        return userRepo.findAll();
    }

    public User saveUser(User user, Roles roles) {
        User userdb = userRepo.findByEmail(user.getEmail());

        if (userdb != null) {
            return null;
        }

        user.setRoles(Collections.singleton(roleRepo.findByName(roles.toString())));

        if (user.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
