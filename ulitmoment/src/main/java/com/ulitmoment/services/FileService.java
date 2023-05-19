package com.ulitmoment.services;

import com.ulitmoment.entities.User;
import com.ulitmoment.repos.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    @Autowired
    private FileRepo fileRepo;

    public void save(MultipartFile file, User user, String path) throws Exception {
        path = user.getId() + "/" + path;
        fileRepo.save(file, path);
    }

    public void save(byte[] file, User user, String path) throws Exception {
        path = user.getId() + "/" + path;
        fileRepo.save(file, path);
    }
}
