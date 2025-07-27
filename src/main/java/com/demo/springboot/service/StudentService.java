package com.demo.springboot.service;

import com.demo.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    String delete(Student student);

    Student update(Student student);

    Student findById(Long id);

    Student findByEmail(String email);
}
