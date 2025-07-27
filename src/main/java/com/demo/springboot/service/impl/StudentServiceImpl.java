package com.demo.springboot.service.impl;

import com.demo.springboot.entity.Student;
import com.demo.springboot.repository.StudentRepository;
import com.demo.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String delete(Student student) {
        Student studentToDelete = studentRepository.findById(student.getId())
                .orElse(null);
        if (studentToDelete != null) {
            studentRepository.delete(studentToDelete);
            return "Student deleted successfully";
        }
        return "The student does not exist";
    }

    @Override
    public Student update(Student student) {
        // search for the object
        Student studentToUpdated = studentRepository.findById(student.getId())
                .orElse(null);

        if (studentToUpdated != null) {
            // modify and save the object

            studentToUpdated.setFirstname(student.getFirstname());
            studentToUpdated.setLastname(student.getLastname());
            studentToUpdated.setEmail(student.getEmail());
            studentToUpdated.setPhone(student.getPhone());
            studentToUpdated.setAge(student.getAge());

            studentRepository.save(studentToUpdated);
        }

        return studentToUpdated;
    }

    @Override
    public Student findById(Long id) {

        return studentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElse(null);
    }
}
