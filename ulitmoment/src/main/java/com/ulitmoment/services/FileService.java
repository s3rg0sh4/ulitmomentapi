package com.ulitmoment.services;

import com.ulitmoment.entities.Course;
import com.ulitmoment.entities.FileDetails;
import com.ulitmoment.entities.User;
import com.ulitmoment.repos.CourseRepo;
import com.ulitmoment.repos.FileDetailsRepo;
import com.ulitmoment.repos.FileSystemRepo;
import com.ulitmoment.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    @Autowired
    private FileDetailsRepo fileDetailsRepo;
    @Autowired
    private FileSystemRepo fileSystemRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepo courseRepo;

    public void save(MultipartFile file, Course course) {
        FileDetails fileDetails = new FileDetails(file.getOriginalFilename());
        course.setPic(fileDetails);
        fileDetailsRepo.save(fileDetails);
        courseRepo.save(course);
        String path = "courses/" + course.getId().toString();
        fileSystemRepo.save(file, path);
    }

    public FileSystemResource get(Course course) {
        try {
            String path = "courses/" + course.getId().toString() + "/" + course.getPic().getPath();
            return fileSystemRepo.get(path);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(MultipartFile file, User user) {
        FileDetails fileDetails = new FileDetails(file.getOriginalFilename());
        user.setPic(fileDetails);
        fileDetailsRepo.save(fileDetails);
        userRepo.save(user);
        String path = "user/" + user.getEmail().toString();
        fileSystemRepo.save(file, path);
    }

    public FileSystemResource get(User user) {
        try {
            String path = "user/" + user.getEmail().toString() + "/" + user.getPic().getPath();
            return fileSystemRepo.get(path);
        } catch (Exception e) {
            return null;
        }
    }
}
