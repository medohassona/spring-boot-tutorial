package com.demo.springboot.service;

import com.demo.springboot.entity.StudentProfile;
import com.demo.springboot.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileService(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public StudentProfile save(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }
}
