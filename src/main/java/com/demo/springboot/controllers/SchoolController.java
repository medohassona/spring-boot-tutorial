package com.demo.springboot.controllers;

import com.demo.springboot.entity.School;
import com.demo.springboot.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.findAll();
    }

    @PostMapping
    public School save(@RequestBody School school) {
        return schoolService.save(school);
    }
}
