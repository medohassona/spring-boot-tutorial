package com.demo.springboot.mapper;

import com.demo.springboot.dto.StudentRequest;
import com.demo.springboot.dto.StudentResponse;
import com.demo.springboot.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    // mapping method => a method that transform and object from type to another
    public Student toStudent(StudentRequest dto) {
        Student student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        return student;
    }

    public StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(
                student.getFirstname(),
                student.getLastname()
        );
    }
}
