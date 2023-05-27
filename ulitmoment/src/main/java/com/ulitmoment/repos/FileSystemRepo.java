package com.ulitmoment.repos;

import jakarta.transaction.Transactional;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Repository
@Transactional
public class FileSystemRepo {
    private final Path root = Paths.get("uploads");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public void save(MultipartFile file, String dir) {
        try {
            Files.createDirectories(Files.createDirectories(root.resolve(dir)));
            Files.copy(file.getInputStream(), root.resolve(dir + "/" + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    public FileSystemResource get(String path) {
        if (new File(root.resolve(path).toUri()).exists()) {
            return new FileSystemResource(root.resolve(path));
        }
        return null;
    }
}