package com.demo.springboot.controllers;

import com.demo.springboot.entity.Student;
import com.demo.springboot.entity.StudentProfile;
import com.demo.springboot.service.StudentProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public StudentProfile addStudent(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.save(studentProfile);
    }
}
