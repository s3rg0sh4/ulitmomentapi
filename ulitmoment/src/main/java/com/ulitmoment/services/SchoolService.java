package com.ulitmoment.services;

import com.ulitmoment.entities.School;
import com.ulitmoment.repos.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;

    public List<School> schoolList() {
        return schoolRepo.findAll();
    }

    public void addSchool(School school) {
        schoolRepo.save(school);
    }

    public School getSchool(Long id) {
        return schoolRepo.getById(id);
    }
}
