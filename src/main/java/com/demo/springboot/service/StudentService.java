package com.demo.springboot.service;

import com.demo.springboot.dto.StudentRequest;
import com.demo.springboot.dto.StudentResponse;
import com.demo.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    Student save(StudentRequest student);

    String delete(Student student);

    Student update(Student student);

    Student findById(Long id);

    Student findByEmail(String email);
}
