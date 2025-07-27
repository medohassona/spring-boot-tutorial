package com.demo.springboot.service.impl;

import com.demo.springboot.dto.StudentRequest;
import com.demo.springboot.dto.StudentResponse;
import com.demo.springboot.entity.Student;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.repository.StudentRepository;
import com.demo.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;

        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentResponse)
                .toList();
    }

    @Override
    public Student save(StudentRequest studentDto) {
        return studentRepository.save(studentMapper.toStudent(studentDto));
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
